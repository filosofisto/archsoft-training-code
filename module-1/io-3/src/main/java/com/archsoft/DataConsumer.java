package com.archsoft;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DataConsumer {

    private File source;

    private DataInputStream in;

    private List<Integer> list;

    private int total;

    private int count;

    public DataConsumer from(File source) {
        this.source = source;
        return this;
    }

    public DataConsumer prepare() throws FileNotFoundException {
        prepareInput();
        prepareList();
        prepareStat();

        return this;
    }

    private void prepareStat() {
        total = 0;
        count = 0;
    }

    private void prepareList() {
        list = new ArrayList<>();
    }

    private void prepareInput() throws FileNotFoundException {
        Objects.requireNonNull(source);

        in = new DataInputStream(new FileInputStream(source));
    }

    public DataConsumer read() throws IOException {
        Objects.requireNonNull(in);

        int valor;

        for (;;) {
            try {
                valor = in.readInt();

                list.add(valor);
                count++;
                total += valor;
            } catch (EOFException e) {
                break;
            }
        }

        return this;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public int[] getData() {
        Objects.requireNonNull(list);

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    public void close() throws IOException {
        in.close();
    }
}
