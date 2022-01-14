package com.nt.jdbc1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class SelectTestTWRPostgresOracleTest {

	public static void main(String[] args) {
		try(
				//establish the connection
				Connection  con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system" , "aachal");
				
				//create Statement obj having precompiled sql query
			
			     Statement st= con.createStatement();
					
				// send and EXECUTE QUERY
	    		   ResultSet rs = st.executeQuery("SELECT PID ,PNAME,PRIZE,QTY,STATUS FROM PRODUCT");
	       )
		 {
	    	//process the ResultSet object
	    	if(rs!=null) {
	    		boolean flag= false;
	    		
	    		while(rs.next()) {
	    			flag = true;
	    		   System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getInt(4)+" " +rs.getString(5));
	          }//while
	    	
	    		if(flag==false)
	    		  System.out.println("NO RECORD FOUND");
	    	}//if 	   
         } //try   (all jdbc obj are closed)
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
