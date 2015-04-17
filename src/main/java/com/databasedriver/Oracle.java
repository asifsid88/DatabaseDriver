package com.databasedriver;

import java.util.List;
import java.util.Map;

class Oracle implements DatabaseConnection {
	private static Oracle instance;
	
	private Oracle() {}
	
	public static DatabaseConnection getInstance() {
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

	public List<Map<String, Object>> selectQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public int query(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean commit() {
		// TODO Auto-generated method stub
		return false;
	}
}
