package com.databasedriver;

import com.databasedriver.enums.DatabaseType;

public class DatabaseDriver {
	private Database database;
	
	private DatabaseDriver() {}
	
	public Database getInstance(DatabaseType type) {
		switch (type) {
			case MongoDB:
				database = MongoDB.getInstance();			
				break;
			case MySQL:
				database = MySQL.getInstance();
				break;
			case Oracle:
				database = Oracle.getInstance();
				break;
			default:
				break;
		}

		return database;
	}
}
