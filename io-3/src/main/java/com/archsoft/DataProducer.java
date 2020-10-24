package com.archsoft;

import java.io.*;
import java.util.Objects;
import java.util.Random;

public class DataProducer {

    private File target;

    private DataOutputStream out;

    private Random random;

    public DataProducer into(File target) {
        this.target = target;

        return this;
    }

    public DataProducer prepare() throws FileNotFoundException {
        prepareOutput();
        prepareRandom();

        return this;
    }

    private void prepareRandom() {
        random = new Random();
    }

    private void prepareOutput() throws FileNotFoundException {
        Objects.requireNonNull(target);
        out = new DataOutputStream(new FileOutputStream(target));
    }

    public DataProducer produce(int number) throws IOException {
        Objects.requireNonNull(out);
        Objects.requireNonNull(random);

        for (int i = 0; i < number; i++) {
            out.writeInt(random.nextInt(100)+1);
        }

        return this;
    }

    public void close() throws IOException {
        Objects.requireNonNull(out);
        out.close();
    }
}
