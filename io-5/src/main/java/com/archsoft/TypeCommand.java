package com.archsoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TypeCommand implements Command {

    @Override
    public String execute(String input) {
        String targetDir = input.split(" ")[1];
        File file = new File(targetDir);

        StringBuilder builder = new StringBuilder();

        try(Scanner scanner = new Scanner(file).useDelimiter("\n")) {
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
