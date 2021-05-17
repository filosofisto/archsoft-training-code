package com.archsoft.controller;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.payment.Payment;
import com.archsoft.service.PaymentService;
import com.archsoft.to.payment.PaymentTO;
import com.archsoft.util.converter.PaymentConverter;
import com.archsoft.util.converter.ProductConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    private final PaymentConverter paymentConverter;

    public PaymentController(PaymentService paymentService, PaymentConverter paymentConverter) {
        this.paymentService = paymentService;
        this.paymentConverter = paymentConverter;
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentTO> create(@RequestBody PaymentTO paymentTO) throws IOException {
        Payment product = paymentConverter.toEntity(paymentTO);
        Payment paymentCreated = paymentService.create(product);

        return ResponseEntity.ok(paymentConverter.toTransferObject(paymentCreated));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<PaymentTO> read(@PathVariable("id") String id) throws RecordNotFoundException {
        Payment payment = paymentService.find(id);

        return ResponseEntity.ok(paymentConverter.toTransferObject(payment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws RecordNotFoundException, IOException {
        paymentService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<PaymentTO> update(@RequestBody PaymentTO paymentTO) throws RecordNotFoundException, IOException {
        Payment payment = paymentConverter.toEntity(paymentTO);
        Payment paymentUpdated = paymentService.update(payment);

        return ResponseEntity.ok(paymentConverter.toTransferObject(paymentUpdated));
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<PaymentTO>> list() {
        List<Payment> list = paymentService.list();
        Iterable<PaymentTO> paymentTOS = paymentConverter.toTransferObject(list);

        return ResponseEntity.ok(paymentTOS);
    }
}
