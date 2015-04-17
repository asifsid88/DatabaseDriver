package com.databasedriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class MySQL implements DatabaseConnection {
	private static MySQL instance;

	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	private PreparedStatement preparedStatement;

	private MySQL() {
	}

	public static DatabaseConnection getInstance() {
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
	
	private Connection getConnection() {
		return instance.connection;
	}

	private static void initialize() {
		try {
			Class.forName(MySQLConnectionProperties.DRIVER).newInstance();
			instance.connection = DriverManager.getConnection(MySQLConnectionProperties.URL
																+MySQLConnectionProperties.DBNAME, 
																MySQLConnectionProperties.USERNAME, 
																MySQLConnectionProperties.PASSWORD);
		} catch (Exception exception) {
			System.out.println("Exception while creating MySQL Connection: "+exception);
		}
	}

	public List<Map<String, Object>> selectQuery(String query) {
		List<Map<String, Object>> resultList = new LinkedList<Map<String, Object>>();
		try {
			statement = getConnection().createStatement();
			System.out.println("Query: "+query);
			resultSet = statement.executeQuery(query);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			List<String> columnNames = new LinkedList<String>();
			int columnCount = rsmd.getColumnCount();
			while(columnCount > 0) {
				System.out.println(rsmd.getColumnLabel(columnCount));
				columnNames.add(rsmd.getColumnLabel(columnCount));
				columnCount--;
			}
			
			while(resultSet.next()) {
				Map<String, Object> result = new HashMap<String, Object>();
				ListIterator<String> iterator = columnNames.listIterator();
				while(iterator.hasNext()) {
					String columnLabel = iterator.next();
					Object columnValue = null;
					try {
						columnValue = resultSet.getObject(columnLabel);
					} catch(Exception exception) {
						System.out.println("Cannot find column="+columnLabel+" Exception:"+exception);
					}
					result.put(columnLabel, columnValue);
				}
				resultList.add(result);
			}
			
		} catch(Exception exception) {
			System.out.println("Exception occurred in selectQuery : " + query + " Exception: "+exception);
		} finally {
			try {
				if(!statement.isClosed()) {
					statement.close();	
				}	
			} catch(Exception exceptino) {
				System.out.println("Exception occurred while closing the connection related objects");
			}
		}
		
		return resultList;
	}

	public int insertQuery(String tableName, Map<String, Object> params) {
		int count = -1;
		String query="";
		try {
			query = "insert into "+tableName;
			preparedStatement = getConnection().prepareStatement(query);
			
			// TODO: complete the logic
			
		} catch(Exception exception) {
			System.out.println("Exception occurred in insertQuery : " + query + " Exception: "+exception);
		} finally {
			try {
				if(!statement.isClosed()) {
					statement.close();	
				}	
			} catch(Exception exceptino) {
				System.out.println("Exception occurred while closing the connection related objects");
			}
		}
		
		return count;
	}
	
	public int query(String query) {
		int count = -1;
		try {
			statement = getConnection().createStatement();
			System.out.println("Query: "+query);
			count = statement.executeUpdate(query);
			System.out.println(count+ " row(s) affected.");
		} catch(Exception exception) {
			System.out.println("Exception occurred in query : " + query + " Exception: "+exception);
		} finally {
			try {
				if(!statement.isClosed()) {
					statement.close();	
				}	
			} catch(Exception exceptino) {
				System.out.println("Exception occurred while closing the connection related objects");
			}
		}
		
		return count;
	}
	
	public boolean commit() {
		boolean status = false;
		try {
			getConnection().commit();
			status = true;
		} catch(Exception exception) {
			System.out.println("Exception while doing commit:: Exception: "+exception);
		} finally {
			try {
				if(!statement.isClosed()) {
					statement.close();	
				}	
			} catch(Exception exceptino) {
				System.out.println("Exception occurred while closing the connection related objects");
			}
		}
		
		return status;
	}
}
