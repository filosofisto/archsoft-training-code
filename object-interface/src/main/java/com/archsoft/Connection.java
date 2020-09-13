package com.archsoft;

public interface Connection {

    void open();

    String send(String data);

    void close();
}
