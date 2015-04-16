package com.databasedriver.enums;

public enum DatabaseType {
	MongoDB,
	MySQL,
	Oracle;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
