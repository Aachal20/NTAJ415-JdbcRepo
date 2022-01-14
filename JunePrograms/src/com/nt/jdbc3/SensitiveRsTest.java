package com.nt.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveRsTest {
    private static final String EMP_SELECT_QUERY ="SELECT  SNO ,SNAME,SADD , AVG FROM STUDENT";
    
	public static void main(String[] args) {
	    
	
				 try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","aachal");
					        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								 ResultSet rs = st.executeQuery(EMP_SELECT_QUERY);
		     	){		
                    if(rs!=null) {
                    	System.out.println("RS Record top to botttom");
                    	int count = 0;
                    	
                    	while(rs.next()) {
                    		if(count == 0)
                    			Thread.sleep(30000);
                    		rs.refreshRow();
                    		count++;
                    		System.out.println( "----->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
                    	}//while
                    }//if
				 
           }//try
	      catch(SQLException se) {
	    	 se.printStackTrace();
	      }
		 catch(Exception  e) {
			 e.printStackTrace();
		 }
	}//main

}//class
