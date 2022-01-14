package com.nt.jdbc;


	import java.sql.Statement;
	import java.sql.Connection;	
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class PSLoginApp_Type2_OCI {

		public static void main(String[] args) {
			
			 final String  LOGIN_QUERY= "SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME=? AND PWD=?";
			Scanner sc =null;
			Connection con=null;
			ResultSet rs = null;
			PreparedStatement ps=null;
			
			
			try {
				//READ INPUT
				 sc =new Scanner(System.in);
				 String user=null,pass=null;
				 
				 if(sc!=null){
					 System.out.println("enter login username");//gives raja rao
					 user=sc.nextLine();
					 System.out.println("enter the password");//gives rao rao
					 pass=sc.nextLine();
				 }//if
					
							
				//Load jdbc driver class
			     Class.forName("oracle.jdbc.driver.OracleDriver");
	             //establishb the connection
			     con=DriverManager.getConnection("jdbc:oracle:oci8:@xe" , "system","aachal");
			     
			     
				//Create jdbc  PreparedStatement object
			     if(con!=null)
			         ps  = con.prepareStatement(LOGIN_QUERY);
			     
			     //Set VALUES TO PARAM of precompiled sql bquery
			     if(ps!=null) {
			    	 ps.setString(1, user);
			       ps.setString(2, pass);
			     }
			     //prepare sql query
			     //select count(*) from IRCTC_TAB where uname=raja and pwd=rani
			     //String query="SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME="+user+ "AND PWD ="+pass;
			    //String query="select count(*) from IRCTC_TAB where uname="+user+"and  pwd="+pass;
			    System.out.println();
			     
			   
			       //send and execute sql query to db s/w
			     if(ps!=null)
			       rs = ps.executeQuery();
			     
			      //process the resultset object
			      if(rs!=null) {
			    	 rs.next();
			    	 
			        int count=rs.getInt(1);
			     
			     
			        //process the result
			      if(count==0)
			    	 System.out.println("INVALID CREDENTIALS");
			     else
			    	 System.out.println("VALID CREDENTIALS");
			     }//if	 
			   }//try
			
		   catch(SQLException se){
			     se.printStackTrace();
	     	}
	     	catch(Exception e) {
			     e.printStackTrace();
		    }
			
			finally {
				
			   try {
				if(rs!=null)
					rs.close();
				 
			   }
			   catch(SQLException se) {
				se.printStackTrace();
			   }
			
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
			try {
				if(sc!=null)
					sc.close();
				 
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			}//finally
		}//class
	}	

			

