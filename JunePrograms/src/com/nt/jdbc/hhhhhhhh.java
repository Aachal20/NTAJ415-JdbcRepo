package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class hhhhhhhh {
	 private static final String INSERT_ARTIST_VALUE = "INSERT INTO ARTIST_INFO VALUES (AR_SEQ.NEXTVAL) values(?,?)";
	 public static void main(String[] args) {      
		 try(Scanner sc=new Scanner(System.in)){
				//read inputs
				String name=null, addr=null;
		 	//String photoLoc=null;
				if(sc!=null) {
					System.out.println("Enter Artist Name::");
					name= sc.next();
					System.out.println("Enter Artist Address::");
					addr= sc.next();
					//System.out.println("Enter Artist photo location::");
					//photoLoc= sc.next();
			}//if
				//create inputStream pointing to photo file
				try(InputStream is =new FileInputStream("e://photos\\dt.png");){
					try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "manager");
							PreparedStatement ps = con.prepareStatement(INSERT_ARTIST_VALUE);){
						//set values to query param
						if(ps!=null) {
						ps.setString(1 ,name);
						ps.setString(2, addr);
						ps.setBlob(3, is);
						
					}
						//execute the query
					int count=0;
					if(ps!=null)
						count=ps.executeUpdate();
					//process the resltset
					if(count==0)
						 System.out.println("record not inserted");
					else
						System.out.println("record is inserted");
					}//try
				}//try
				
				
			
		}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		 
	 }
	 }

