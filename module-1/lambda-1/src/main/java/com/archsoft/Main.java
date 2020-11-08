package com.archsoft;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Rodrigo", 75, false);
        User u2 = new User("Jeronimo", 79, true);
        User u3 = new User("Francesca", 82, false);

        List<User> users = Arrays.asList(u1, u2, u3);

//        1 - Old style
//        for (User user: users) {
//            System.out.println(user.getName());
//        }

//        2 - forEach + Consumer
//        users.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                out.println(user.getName());
//            }
//        });

//        3 - Lambda
//        Consumer<User> shower = (User user) -> {
//            out.println(user.getName());
//        };
//        users.forEach(shower);

//        4 - Lambda (ocultando o tipo do parametro)
//        Consumer<User> shower = user -> {
//            out.println(user.getName());
//        };
//        users.forEach(shower);

//        5 - Lambda (removendo colchetes - apenas 1 comando)
//        Consumer<User> shower = user -> System.out.println(user.getName());
//        users.forEach(shower);

//        6 - Lambda: versao mais otimizada
//        users.forEach(user -> System.out.println(user.getName()));

//        7 - Reference Method
        users.forEach(User::print);
    }
}
