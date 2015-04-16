package com.databasedriver;

/**
 * These shall be fed from the properties file
 * 
 * We can have all the connection properties in this file
 * @author m.asif
 *
 */
class MongoConnectionProperties {
	public static final String USERNAME = "";
	public static final String PASSWORD = "";
	public static final String URL = "";
	public static final String DBNAME = "";
}

class MySQLConnectionProperties {
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String URL = "jdbc:mysql://localhost/";
	public static final String DBNAME = "experiment";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
}