package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type3DriverSelectTest {

	public static void main(String[] args) {
		try {
			//load driver class
			Class.forName("ids.sql.IDSDriver");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try(	Connection con = DriverManager.getConnection("jdbc:ids//localhost:12/conn?dsn=accdsn");
				
				Statement st = con.createStatement();
				 
				 ResultSet  rs = st.executeQuery("SELECT * FROM student");
				  
		){
	
	      //process the result set object
	        	if(rs!=null) {
		       while(rs.next()){
			           System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getFloat(4));			
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
