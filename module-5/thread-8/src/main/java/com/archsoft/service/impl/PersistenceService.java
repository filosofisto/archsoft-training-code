package com.archsoft.service.impl;

import com.archsoft.model.Client;
import com.archsoft.util.Util;

import static java.lang.System.out;

public class PersistenceService {

    public void save(Client client) {
        // persist client into database
        out.println("Persistence of client in process...");
        Util.waitFor(1);
        out.println("Client saved into database");
    }
}
