package com.archsoft;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            out.println("Favor passar a classe a ser executada");
            System.exit(-1);
        }

        DynamicLoader loader = new DynamicLoader();

        CustomExecution execution = loader.load(args[0], args[1]);
        String output = execution.process();
        out.println(output);
    }


}
