package com.archsoft;

public interface Connection {

    void open();

    String send(String data);

    void close();

    boolean isOpen();

    default void ping() {
        if (!isOpen()) {
            open();
        }

        send("ping");
    }
}
