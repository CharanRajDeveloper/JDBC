package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Register the Driver Class
		Class.forName("com.mysql.jdbc.Driver");
		//create the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_invoicing?useSSL=false","root","");
		//create the statement
		Statement stmt=con.createStatement();
		//Executing the queries
		ResultSet rs=stmt.executeQuery("SELECT * FROM sql_invoicing.clients");
		while(rs.next()) {
			System.out.println("Client ID:"+rs.getInt("client_id"));
			System.out.println("Name:"+rs.getString("name"));
			System.out.println("Address:"+rs.getString("address"));
			System.out.println("City:"+rs.getString("city"));
			System.out.println("State:"+rs.getString("state"));
			System.out.println("Phone Number:"+rs.getString("phone"));
		}
	}

}
