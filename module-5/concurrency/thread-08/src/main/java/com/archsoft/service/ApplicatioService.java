package com.archsoft.service;

import com.archsoft.exception.InvalidDataException;
import com.archsoft.model.Client;

public interface ApplicatioService {

    void saveClient(Client client) throws InvalidDataException;
}
