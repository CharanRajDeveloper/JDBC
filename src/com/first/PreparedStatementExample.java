package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_invoicing?useSSL=false", "root",
				"");
		PreparedStatement pstmt = con.prepareStatement(
				"insert into sql_invoicing.clients values(?,?,?,?,?,?)");
         pstmt.setInt(1, 6);
         pstmt.setString(2, "Charan");
         pstmt.setString(3, "Bangalore");
         pstmt.setString(4, "Bangalore");
         pstmt.setString(5, "KA");
         pstmt.setString(6, "1234567890");
         int result=pstmt.executeUpdate();
         if(result>0) {
        	 System.out.println("Successfully updated...");
         }else {
        	 System.out.println("Failed to upload...");
         }
	}

}
