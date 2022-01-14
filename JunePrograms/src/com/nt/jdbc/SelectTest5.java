package com.nt.jdbc;


		
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;

		import java.sql.*;

		public class SelectTest5 {

			public static void main(String[] args) {
			
				Connection con=null;
			    Statement st=null;
			    ResultSet rs=null;
			    
			
			    	try {
			     
			    //Register driver by loading jdbc driver class
					//Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//establish the connection
			    	con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" , "aachal");
				
					//create statement object
			    	//if(con!=null)
			    		//st = con.createStatement();
			    	 if(con!=null)
			        	 st = con.createStatement();
			    	
			    	//prepare sql query
			    	String query= "SELECT COUNT(*) FROM STUDENT";
				    System.out.println(query);
				    
				    //send and execute the query
				    if(st!=null) {
				    	rs= st.executeQuery(query);
				    }
				    //process the resultset
				    if(rs!=null) {
				    	rs.next();
				    	int count=rs.getInt("COUNT(*)");
				    	
				    	//System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getShort(3));
				 
				    	System.out.println("Record Count inStudent DB Table::" +count);
			    }//if
			  }//try
			catch(SQLException se) {
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
				catch(SQLException se){
					se.printStackTrace();
				}
				
				
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
				
			}//finalyy
				
			}//main
		}//class
			    
				
			




	


