package com.archsoft.mongodb.controller;

import com.archsoft.mongodb.converter.CustomerConverter;
import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Customer;
import com.archsoft.mongodb.service.CustomerService;
import com.archsoft.mongodb.to.CustomerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerController(CustomerService CustomerService, CustomerConverter customerConverter) {
        this.customerService = CustomerService;
        this.customerConverter = customerConverter;
    }

    @PostMapping
    public ResponseEntity<CustomerTO> create(@RequestBody CustomerTO customerTO) {
        Customer customer = customerConverter.toEntity(customerTO);
        Customer customerResponse = customerService.create(customer);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerTO> read(@PathVariable("id") String id) throws RecordNotFoundException {
        Customer customerResponse = customerService.find(id);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<CustomerTO> findByEmail(@PathVariable("email") String email) throws RecordNotFoundException {
        Customer customerResponse = customerService.findByEmail(email);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws RecordNotFoundException {
        customerService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<CustomerTO> update(@RequestBody CustomerTO customerTO) throws RecordNotFoundException {
        Customer customer = customerConverter.toEntity(customerTO);
        Customer customerResponse = customerService.update(customer);

        return ResponseEntity.ok(customerConverter.toTransferObject(customerResponse));
    }

    @GetMapping
    public ResponseEntity<Iterable<CustomerTO>> list() {
        List<Customer> list = customerService.list();

        return ResponseEntity.ok(customerConverter.toTransferObject(list));
    }
}
