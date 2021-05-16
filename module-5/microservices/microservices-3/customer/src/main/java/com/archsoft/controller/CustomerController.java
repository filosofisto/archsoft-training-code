package com.archsoft.controller;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.customer.Customer;
import com.archsoft.service.CustomerService;
import com.archsoft.to.customer.CustomerTO;
import com.archsoft.util.converter.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerController(CustomerService CustomerService, CustomerConverter customerConverter) {
        this.customerService = CustomerService;
        this.customerConverter = customerConverter;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerTO> create(@RequestBody CustomerTO customerTO) {
        Customer customer = customerConverter.toEntity(customerTO);
        Customer customerResponse = customerService.create(customer);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<CustomerTO> read(@PathVariable("id") String id) throws RecordNotFoundException {
        Customer customerResponse = customerService.find(id);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<CustomerTO> findByEmail(@PathVariable("email") String email) throws RecordNotFoundException {
        Customer customerResponse = customerService.findByEmail(email);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws RecordNotFoundException {
        customerService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerTO> update(@RequestBody CustomerTO customerTO) throws RecordNotFoundException {
        Customer customer = customerConverter.toEntity(customerTO);
        Customer customerResponse = customerService.update(customer);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<CustomerTO>> list() {
        List<Customer> list = customerService.list();

        return ResponseEntity.ok(customerConverter.toTransferObject(list));
    }

    @GetMapping("/validate/{customerId}")
    public ResponseEntity<Boolean> validate(@PathVariable("customerId") String customerId) {
        boolean valid = customerService.validate(customerId);

        return ResponseEntity.ok(valid);
    }
}
