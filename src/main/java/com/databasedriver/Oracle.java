package com.databasedriver;

class Oracle implements Database {
	private static Oracle instance;
	
	private Oracle() {}
	
	public static Database getInstance() {
		if(instance == null) {
			synchronized(Oracle.class) {
				if(instance == null) {
					instance = new Oracle();
					// do all the things to create the connection
				}
			}
		}
		
		return instance;
	}
}
