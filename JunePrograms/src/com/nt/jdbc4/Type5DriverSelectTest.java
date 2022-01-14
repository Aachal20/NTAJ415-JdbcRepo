package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type5DriverSelectTest {
	private static final String 	SELECT_STUDENT_QUERY ="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";

	public static void main(String[] args) {
	
		 try(Connection con = DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;serviceName=xe","system","aachal");
                Statement st = con.createStatement();
				 ResultSet rs = st.executeQuery(SELECT_STUDENT_QUERY);
				 ){
					 //PROCESS THE RESULTSET OBJECT
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
	}

}
