package com.archsoft;

import java.util.*;

public class Keyboard {

    private Map<String, Command> commands;

    private Command emptyCommand = input -> "Command " + input + " not found";

    public Keyboard() {
        initShutdownKook();
        initCommands();
    }

    private void initShutdownKook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println("Shutting down ...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    private void initCommands() {
        commands = new HashMap<>();
    }

    public void registerCommand(String identifier, Command command) {
        commands.put(identifier, command);
    }

    public void start() {
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = readCommand(scanner);

//                if (Objects.nonNull(input)) {
//                    Command command = commands.get(input.split(" ")[0]);
//
//                    if (Objects.nonNull(command)) {
//                        System.out.println(command.execute(input));
//                    } else {
//                        System.out.println(emptyCommand.execute(input.split(" ")[0]));
//                    }
//                }

                Optional.of(input)
                        .map(s -> s.split(" ")[0])
                        .map(s -> commands.get(s))
                        .ifPresentOrElse(
                                command -> System.out.println(command.execute(input)),
                                () -> System.out.println(emptyCommand.execute(input.split(" ")[0]))
                        );
            }
        }
    }

    private String readCommand(Scanner scanner) {
        System.out.print("> ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }

        return null;
    }
}
