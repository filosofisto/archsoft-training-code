package com.archsoft;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.print("Enter base directory: ");
        String directory = in.nextLine();

        out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();

        try {
            out.println(task.get() + " matching files.");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
