package com.archsoft;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connect();
        connection.open();
        String result = connection.send("aws ls ec2");
        System.out.printf("Result: %s\n", result);
        connection.close();
    }
}
