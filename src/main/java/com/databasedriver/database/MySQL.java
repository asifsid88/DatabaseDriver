package com.databasedriver.database;

public class MySQL implements Database {
	private static MySQL instance;
	
	// other properties of connection and everything else will be as a member variable
	
	private MySQL() {}
	
	public static Database getInstance() {
		if(instance == null) {
			synchronized(MySQL.class) {
				if(instance == null) {
					instance = new MySQL();
					// do all the things to create the connection
				}
			}
		}
		
		return instance;
	}
}
