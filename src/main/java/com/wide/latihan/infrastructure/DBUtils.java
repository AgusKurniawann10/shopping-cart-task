package com.wide.latihan.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static final String JDBC_URL = "jdbc:mysql://localhost/myspring_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
	
	
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

	public static void init(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		// TODO Auto-generated method stub
		
	}
}
