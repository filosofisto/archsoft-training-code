package com.archsoft.database;

import com.archsoft.Connection;

public class DatabaseConnection implements Connection {

    private boolean opened;

    @Override
    public void open() {
        opened = connectWithDatabase();
    }

    private boolean connectWithDatabase() {
        // try to connect with database
        // if can connect return true
        return true;
    }

    @Override
    public String send(String data) {
        if (!opened) {
            return "Connection not opened";
        }

        return "Data " + data + " sent with success";
    }

    @Override
    public void close() {
        opened = false;
    }

    @Override
    public boolean isOpen() {
        return opened;
    }
}
