package com.archsoft.service.impl;

import com.archsoft.exception.InvalidDataException;
import com.archsoft.model.Client;
import com.archsoft.util.Util;

import static java.lang.System.out;

public class ValidatorService {

    public void validateAddress(Client client) throws InvalidDataException {
        // consume some service to validate address
        out.println("Address validation in process...");
        Util.waitFor(2);
        out.println("Address validated");
    }

    public void validatePhone(Client client) throws InvalidDataException {
        // consume some service to validate phone
        out.println("Phone validation in process...");
        Util.waitFor(1);
        out.println("Phone validated");
    }

    public void validateDocument(Client client) throws InvalidDataException {
        // consume some services to validate document
        out.println("Document validation in process...");
        Util.waitFor(3);
        out.println("Document validated");
    }
}
