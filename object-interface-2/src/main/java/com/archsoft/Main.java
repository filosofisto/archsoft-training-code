package com.archsoft;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connect();
        connection.ping();
        connection.close();
    }
}
