package com.databasedriver.database;

public class MongoDB implements Database {
	private static MongoDB instance;
	
	private MongoDB() {}
	
	public static Database getInstance() {
		if(instance == null) {
			synchronized(MongoDB.class) {
				if(instance == null) {
					instance = new MongoDB();
					// do all the things to create the connection
				}
			}
		}
		
		return instance;
	}
}
