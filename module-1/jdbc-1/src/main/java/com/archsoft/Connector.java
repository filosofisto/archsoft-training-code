package com.archsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static final String DRIVER_CLASS = "org.postgresql.Driver";
	public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

	public static Connection connect()
			throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		
		return DriverManager.getConnection(DATABASE_URL, "postgres", "socrates");
	}
}
