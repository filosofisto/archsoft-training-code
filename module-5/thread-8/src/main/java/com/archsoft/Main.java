package com.archsoft;

import com.archsoft.exception.InvalidDataException;
import com.archsoft.model.Address;
import com.archsoft.model.Client;
import com.archsoft.model.Document;
import com.archsoft.model.Phone;
import com.archsoft.service.ApplicatioService;
import com.archsoft.service.impl.AsyncApplicationService;

public class Main {

    public static void main(String[] args) {
        // Mode data struct
        Client client = Client.builder()
                .address(Address.builder()
                        .state("DF")
                        .country("Brasil")
                        .city("Brasilia")
                        .street("Rua das Araucarias")
                        .number("102")
                        .build())
                .phone(Phone.builder()
                        .number("61 98166-9830")
                        .build())
                .document(Document.builder()
                        .number("2080364")
                        .emitter("SSP/SC")
                        .build())
                .build();

//        ApplicatioService applicatioService = new DefaultApplicationService();
        ApplicatioService applicatioService = new AsyncApplicationService();

        long t1 = System.currentTimeMillis();

        try {
            applicatioService.saveClient(client);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.printf("Processing time: %d sec", (t2-t1)/1000);
    }
}
