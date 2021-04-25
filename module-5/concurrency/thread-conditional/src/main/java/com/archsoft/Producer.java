package com.archsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Producer extends Thread {

    private static final Logger log = Logger.getLogger(Producer.class.getName());

    private final String filename;
    private final SharedFiFoQueue queue;

    public Producer(String filename, SharedFiFoQueue queue) {
        this.filename = filename;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader rd = new BufferedReader(new FileReader(filename))) {
            String inputLine;

            while ((inputLine = rd.readLine()) != null) {
                String[] inputWords = inputLine.split(" ");

                for (String inputWord : inputWords) {
                    queue.add(inputWord);
                }
            }

            //Terminate the execution.
            queue.add(null);
        } catch (InterruptedException e) {
            log.severe("An InterruptedException was caught: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            log.severe("An IOException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
