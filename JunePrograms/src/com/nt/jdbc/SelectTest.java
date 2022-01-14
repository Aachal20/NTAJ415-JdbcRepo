package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] ags) throws Throwable  {
		//load jdbc driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system" , "manager");
		//create jdbc statement object(
		Statement st = con.createStatement();
		//send and execute sql query to DB s/w and gather result
		ResultSet rs =st.executeQuery("SELECT * FROM  DDDD");
		while(rs.next()!=false) {
			System.out.println(rs.getString(1)+ " " +rs.getString(2));

		}
		//CLOSE JDBC OBJ
		rs.close();
		st.close();
		con.close();
	}
} 
