package com.archsoft;

import com.archsoft.model.Person;
import com.archsoft.service.ApplicatioService;
import com.archsoft.service.impl.AsyncApplicationService;
import com.archsoft.service.impl.DefaultApplicationService;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

//        ApplicatioService applicatioService = new DefaultApplicationService();
        ApplicatioService applicatioService = new AsyncApplicationService();

        long t1 = System.currentTimeMillis();

        Person person = applicatioService.processAnyValidPerson();

        long t2 = System.currentTimeMillis();
        out.printf("Processing time: %d sec\n", (t2-t1)/1000);
        out.printf("Selected person: %s\n", person.getName());
    }
}
