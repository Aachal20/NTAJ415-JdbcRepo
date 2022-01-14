package com.nt.jdbc;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

 public class DropTableTest {
			
				public static void main(String[] args) {
					
				Connection con = null;
			    Statement st = null;
			    try {
		       //Load jdbc driver class
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			    //establish the connection
		    	 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "manager");
		    	 //Create JDBC statement obj(vehicle)
		    	  if(con!=null)
		        	 st = con.createStatement();
		    	  //prepare the sql query
		    	  String query="DROP TABLE IRCTC_AACHAL5";
		    	  System.out.println(query);
		    	  //semd and execute the sql query to DB s/w
		    	  int count=0;
		    	  if(st!=null)
		    		count =  st.executeUpdate(query);
		    	  System.out.println("count: :" +count);
		    	  //process the result
		    	  if(count==0)
		    		  System.out.println("DB table is deleted");
		    	  else
		    		  System.out.println("DB table is not deleted");
			    }//try
			    catch(SQLException se) {
			    	se.printStackTrace();
			    	
			    	if(se.getErrorCode()==955)
			    		System.out.println("DB table is alredy created");
			    }
			    catch(Exception e) {
			    	e.printStackTrace();
			    }
			    finally {
			    	//close jdbc object
			    	try {
			    		if(st!=null)
			    			st.close();
			    	}
			    	catch(SQLException se) {
			    		se.printStackTrace();
			    	}
			    	
			    	try {
			    		if(con!=null)
			    			con.close();
			    	}
			    	catch(SQLException se) {
			    		se.printStackTrace();
			    	}
			    	
			    }//finally
		    
		    }//main
		    

		}//class


	


