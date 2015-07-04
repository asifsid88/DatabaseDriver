package com.databasedriver.enums;

public enum DatabaseConnectionType {
	MongoDB,
	MySQL;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
