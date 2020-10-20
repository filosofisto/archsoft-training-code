package com.archsoft;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.mapLibraryName;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Rodrigo", 75, false);
        User u2 = new User("Jeronimo", 79, true);
        User u3 = new User("Francesca", 82, false);
        User u4 = new User("Joao", 83, false);

        List<User> users = Arrays.asList(u1, u2, u3, u4);

//        users.stream()
//                .filter(user -> user.isModerator())
//                .forEach(User::print);

//        users.stream()
//                .filter(user -> !user.isModerator())
//                .filter(user -> user.getPoints() < 80)
//                .forEach(User::print);

//        List<User> moderators = users.stream()
//                .filter(User::isModerator)
//                .sorted(Comparator.comparing(User::getName))
//                .collect(Collectors.toList());

        Set<Integer> points = users.stream()
                .filter(user -> user.getPoints() > 75)
                .sorted(Comparator.comparingInt(User::getPoints).reversed())
                .map(user -> user.getPoints())
                .collect(Collectors.toSet());
        out.println("Quantidade de valores (nao repetidos): " + points.size());
        points.forEach(out::println);

//        users.stream()
//                .max(Comparator.comparingInt(User::getPoints))
//                .map(user -> user.getName())
//                .ifPresentOrElse(
//                        name -> out.println("And the Oscar goes to " + name),
//                        () -> out.println("Who win?")
//                );

//        users.stream()
//                .max(Comparator.comparingInt(User::getPoints))
//                .map(user -> user.getName())
//                .ifPresent(name -> out.println("And the Oscar goes to " + name));

        if (users.stream()
                .max(Comparator.comparingInt(User::getPoints))
                .map(user -> user.getName())
                .isPresent()) {
            out.println("There is a champion");
        }

    }
}
