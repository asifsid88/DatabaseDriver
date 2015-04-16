package com.databasedriver;

import java.sql.Connection;
import java.sql.DriverManager;

class MySQL implements Database {
	private static MySQL instance;

	// other properties of connection and everything else will be as a member
	// variable
	private Connection connection;

	private MySQL() {
	}

	public static Database getInstance() {
		if (instance == null) {
			synchronized (MySQL.class) {
				if (instance == null) {
					instance = new MySQL();
					initialize();
				}
			}
		}

		return instance;
	}

	private static void initialize() {
		try {
			Class.forName(MySQLConnectionProperties.DRIVER);
			StringBuilder connectionString = new StringBuilder();
			connectionString
					.append(MySQLConnectionProperties.URL)
					.append(MySQLConnectionProperties.DBNAME)
					.append("?user=")
					.append(MySQLConnectionProperties.USERNAME)
					.append("&password=")
					.append(MySQLConnectionProperties.PASSWORD);
			
			instance.connection = DriverManager.getConnection(connectionString
					.toString());
		} catch (Exception exception) {
			System.out.println("Exception while creating MySQL Connection: "+exception);
		}
	}
}
