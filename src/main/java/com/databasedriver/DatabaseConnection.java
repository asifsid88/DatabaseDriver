package com.databasedriver;

import java.util.List;
import java.util.Map;

public interface DatabaseConnection {
	List<Map<String, Object>> selectQuery(String query);
	int query(String query);
	boolean commit();
}
