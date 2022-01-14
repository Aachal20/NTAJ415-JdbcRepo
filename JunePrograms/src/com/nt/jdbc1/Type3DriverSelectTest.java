package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type3DriverSelectTest {
	private static final String  SELECT_STUDENT_QUERY="SELECT  *  FROM STUDENT";
	public static void main(String[] args) {
		
		try {
			//load jdbc driver class
			Class.forName("ids.sql.IDSDriver");
			
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn=student");
				Statement st=con.createStatement();
				ResultSet rs = st.executeQuery( SELECT_STUDENT_QUERY);
				){
			//process the resultset obj
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}//while
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
	


