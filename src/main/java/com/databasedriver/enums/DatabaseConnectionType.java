package com.databasedriver.enums;

public enum DatabaseConnectionType {
	MongoDB,
	MySQL,
	Oracle;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
