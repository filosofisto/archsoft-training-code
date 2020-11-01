package com.archsoft;

import com.archsoft.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.out;

@Component
public class ConsoleTask implements CommandLineRunner {

    private RestTemplate restTemplate;

    public ConsoleTask() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void run(String... args) {
        String url = "http://localhost:8080/api/person/all";
        Person[] people = restTemplate.getForObject(url, Person[].class);
        Objects.requireNonNull(people);
        Arrays.stream(people).forEach(out::println);
    }
}
