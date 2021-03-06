package com.databasedriver;

import com.databasedriver.enums.DatabaseConnectionType;

public class DatabaseConnectionDriver {
	private static DatabaseConnection mongoDbConnection;
	private static DatabaseConnection mySqlConnection;
	
	private DatabaseConnectionDriver() {}
	
	public static DatabaseConnection getDatabaseConnection(DatabaseConnectionType type) {
		switch (type) {
			case MongoDB:
				mongoDbConnection = MongoDB.getInstance();
				return mongoDbConnection;
			case MySQL:
				mySqlConnection = MySQL.getInstance();
				return mySqlConnection;
			default:
				break;
		}

		return null;
	}
}
