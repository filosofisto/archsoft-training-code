package com.archsoft;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Rodrigo", 75, false);
        User u2 = new User("Jeronimo", 79, true);
        User u3 = new User("Francesca", 82, false);
        User u4 = new User("Joao", 82, false);

        List<User> users = Arrays.asList(u1, u2, u3);

        System.out.printf("Media: %.2f\n", calcAverage(users));
    }

//    static double calcAverage(List<User> users) {
//        if (users.isEmpty()) {
//            return 0;
//        }
//
//        double total = 0;
//        for (User user: users) {
//            total += user.getPoints();
//        }
//
//        double average = total / users.size();
//
//        return average;
//    }

//    static double calcAverage(List<User> users) {
//        return users.stream()
//                .mapToInt(User::getPoints)
//                .average()
//                .orElse(0);
//    }

//    static double calcAverage(List<User> users) {
//        return users.stream()
//                .mapToInt(User::getPoints)
//                .average()
//                .orElseThrow(IllegalStateException::new);
//    }

    static double calcAverage(List<User> users) {
        return users.stream()
                .mapToInt(User::getPoints)
                .average()
                .orElseThrow(() -> new ArithmeticException("Nao existem elementos para calcular"));
    }
}
