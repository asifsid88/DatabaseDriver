package com.databasedriver;

import java.util.List;
import java.util.Map;

import com.databasedriver.enums.DatabaseConnectionType;

class TestingConnection {

	public static void main(String[] args) throws Exception {
		System.out.println("trying to connect");
		DatabaseConnection dbConnection = DatabaseConnectionDriver.getDatabaseConnection(DatabaseConnectionType.MySQL);
		System.out.println("connected . . .");
		
		for(int i=1; i<10; i++) {
			String query = "insert into test(id, name) values("+i+", 'asif')";
			//int x = dbConnection.query(query);
			//System.out.println(x+" row(s) affected.");	
		}
		
		
		String query = "select * from test";
		List<Map<String, Object>> result = dbConnection.selectQuery(query);
		System.out.println(result);
	}

}
