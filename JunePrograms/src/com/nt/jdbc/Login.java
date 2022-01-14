package com.nt.jdbc;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class Login{

		public static void main(String[] args) {
			Scanner sc=null;
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			try {
				 sc=new Scanner(System.in);
				 String user=null,pass=null;
				 if(sc!=null) {
					 System.out.println("enter login username");
					 user=sc.nextLine();
					 System.out.println("enter the password");
					 pass=sc.nextLine();
				 }//if
				 user="'"+user+"'";
				 pass="'"+pass+"'";
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","MANAGER");
				 if(con!=null)
					 st=con.createStatement();
				 String query =" select count(*) from IRCTC_TAB where uname='rani' and pwd='hyd'";
				 //String query="select count(*) from IRCTC_AACHAL where uname="+user+"and  pwd="+pass;
				// String query="select count(*) from IRCTC_AACHAL where EMAIL="+user+"and  PASSWORD="+pass;
				 System.out.println(query);
				 if(st!=null)
					 rs=st.executeQuery(query);
				 if(rs!=null) {
					 rs.next();
					 int count=rs.getInt(1);
					 if(count==0)
						 System.out.println("invalid credentials");
					 else
						 System.out.println("valid credentials");
					 
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
				catch(SQLException se) {
					se.printStackTrace();
				}
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
				try {
					if(sc!=null)
						sc.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}//finally

		}//main

	}//class


