package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_invoicing?useSSL=false", "root",
				"");
		PreparedStatement pstmt = con.prepareCall("{call getClients(?)}");
		pstmt.setInt(1, 6);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println("Client ID:" + rs.getInt("client_id"));
			System.out.println("Name:" + rs.getString("name"));
			System.out.println("Address:" + rs.getString("address"));
			System.out.println("City:" + rs.getString("city"));
			System.out.println("State:" + rs.getString("state"));
			System.out.println("Phone Number:" + rs.getString("phone"));
		}
	}

}
