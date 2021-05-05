package com.archsoft.mongodb.controller;

import com.archsoft.mongodb.converter.CustomerConverter;
import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Customer;
import com.archsoft.mongodb.service.CustomerService;
import com.archsoft.mongodb.to.CustomerTO;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@GraphQLApi
public class CustomerGraphQLApi {

    private final CustomerService customerService;

    private final CustomerConverter customerConverter;

    public CustomerGraphQLApi(CustomerService customerService, CustomerConverter customerConverter) {
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }

    @GraphQLQuery(name = "listCustomers")
    public Iterable<CustomerTO> list() {
        List<Customer> customerList = customerService.list();
        Iterable<CustomerTO> customerTOList = customerConverter.toTransferObject(customerList);

        return customerTOList;
    }

    @GraphQLQuery(name = "readCustomer")
    public CustomerTO read(@GraphQLArgument(name = "id") String id) throws RecordNotFoundException {
        Customer customer = customerService.find(id);
        return customerConverter.toTransferObject(customer);
    }

    @GraphQLMutation(name = "createCustomer")
    public CustomerTO create(@GraphQLArgument(name = "input") CustomerTO customerTO) {
        Customer customer = customerConverter.toEntity(customerTO);
        Customer customerSaved = customerService.create(customer);

        return customerConverter.toTransferObject(customerSaved);
    }

    @GraphQLMutation(name = "updateCustomer")
    public CustomerTO update(@GraphQLArgument(name = "input") CustomerTO customerTO) throws RecordNotFoundException {
        Customer customerToSave = customerConverter.toEntity(customerTO);
        Customer customerSaved = customerService.update(customerToSave);

        return customerConverter.toTransferObject(customerSaved);
    }

    @GraphQLMutation(name = "deleteCustomer")
    public CustomerTO delete(@GraphQLArgument(name = "id") String id) throws RecordNotFoundException {
        Customer customer = customerService.delete(id);

        return customerConverter.toTransferObject(customer);
    }
}
