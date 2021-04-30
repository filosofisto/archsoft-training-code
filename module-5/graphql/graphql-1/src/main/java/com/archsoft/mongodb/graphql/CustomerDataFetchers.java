package com.archsoft.mongodb.graphql;

import com.archsoft.mongodb.converter.CustomerConverter;
import com.archsoft.mongodb.model.Customer;
import com.archsoft.mongodb.service.CustomerService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataFetchers {

    private final CustomerService customerService;

    private final CustomerConverter customerConverter;

    public CustomerDataFetchers(CustomerService customerService, CustomerConverter customerConverter) {
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }

    /*public DataFetcher readProductDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return customerService.find(id);
        };
    }*/

    public DataFetcher listCustomersDataFetcher() {
        return dataFetchingEnvironment -> customerService.list();
    }

    public DataFetcher createCustomer() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            String email = dataFetchingEnvironment.getArgument("email");

            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);

            Customer customerSaved = customerService.create(customer);

            return customerConverter.toTransferObject(customerSaved);
        };
    }
//
//    public DataFetcher updateProduct() {
//        return dataFetchingEnvironment -> {
//            Map<String, Object> map = dataFetchingEnvironment.getArgument("input");
//            Product product = customerConverter.fromMapToEntity(map);
//
//            Product productSaved = customerService.update(product);
//
//            return customerConverter.toTransferObject(productSaved);
//        };
//    }
//
//    public DataFetcher deleteProduct() {
//        return dataFetchingEnvironment -> {
//            String id = dataFetchingEnvironment.getArgument("id");
//
//            Product productDeleted = customerService.delete(id);
//
//            return customerConverter.toTransferObject(productDeleted);
//        };
//    }
}
