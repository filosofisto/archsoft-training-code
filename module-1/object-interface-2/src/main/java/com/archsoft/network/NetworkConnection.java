package com.archsoft.network;

import com.archsoft.Connection;

public class NetworkConnection implements Connection {

    private boolean connected;

    @Override
    public void open() {
        connected = connectWithSocket();
    }

    private boolean connectWithSocket() {
        // try to connect
        // if can connect return true
        return false;
    }

    @Override
    public String send(String data) {
        if (!connected) {
            int tries = 0;

            do {
                open();
                tries++;
            } while (!connected && tries < 3);

            if (!connected && tries == 3) {
                return "Timeout trying connect to server by socket";
            }
        }

        return null;
    }

    @Override
    public void close() {
        // do something to close the socket
        connected = false;
    }

    @Override
    public boolean isOpen() {
        return connected;
    }
}
