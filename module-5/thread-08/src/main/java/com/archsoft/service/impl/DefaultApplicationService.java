package com.archsoft.service.impl;

import com.archsoft.exception.InvalidDataException;
import com.archsoft.model.Client;
import com.archsoft.service.ApplicatioService;

public class DefaultApplicationService implements ApplicatioService {

    @Override
    public void saveClient(Client client) throws InvalidDataException {
        ValidatorService validatorService = new ValidatorService();
        LogService logService = new LogService();
        PersistenceService persistenceService = new PersistenceService();

        validatorService.validateAddress(client);
        validatorService.validatePhone(client);
        validatorService.validateDocument(client);

        persistenceService.save(client);
    }
}
