package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConfiguration {
	public static Connection getConnection() {
		Connection con=null;
	try {
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ville_france", "root","");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from ville_france");
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}
		System.out.println("Connecté");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return con;
	}
}
