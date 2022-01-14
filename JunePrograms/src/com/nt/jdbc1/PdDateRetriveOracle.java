package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class PdDateRetriveOracle {
	private static final String RETRIVE_DATES_QUERY = "SELECT PID,PNAME,DOB,DOJ,DOM FROM PERSON_INFO_DATES";

   
	public static void main(String[] args) {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
    	 //Load  jdbc driver
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	//establish  the connection
    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system " ,"aachal");
    	//create preparedStatement object
    	if(con!=null)
    		ps=con.prepareStatement(RETRIVE_DATES_QUERY);
    	//EXECUTE QUERY
    	if(ps!=null)
    		rs=ps.executeQuery();
    	//process the ResultSet object
    	if(rs!=null) {
    		while(rs.next()) {
    		System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getString(5));
    		
    		}//while
    	}//if 
    	System.out.println("--------");
    	//process the ResultSet object
    	if(rs!=null) {
    		while(rs.next()) {
    			int pid=rs.getInt(1);
    			String name=rs.getString(2);
    			java.sql.Date sdob = rs.getDate(3);
    			java.sql.Date sdoj = rs.getDate(4);
    			java.sql.Date sdom = rs.getDate(5);
    			
    			/*//convert java.sql.Date  to string date values
    			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    			String sdob= sdf.format(sqdob);
    			String sdoj = sdf.format(sqdom);
    			String  sdom = sdf.format(sqdom);
    			System.out.println(pid+" "name+" " +sdob+" "+sdoj|+" "+sdom);
    		   	
    		}//while
    	}//if*/
     
    catch(SQLException se) {
    	se.printStackTrace();
    	System.out.println("Problem in record insertion::");
    }
catch(Exception e) {
    	e.printStackTrace();
    }
finally {
    	//close jdbc object
    	try {
    		if(ps!=null)
    			ps.close();
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
    
    		}
    	}
    
 
    	

