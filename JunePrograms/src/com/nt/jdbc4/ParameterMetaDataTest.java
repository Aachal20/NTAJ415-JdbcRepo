package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParameterMetaDataTest {

	public static void main(String[] args) {
		  try(	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
				//PreparedStatement ps = con.PrepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			)
		  {
			  //create parameterMetaData obj
			  ParameterMetaData pmd = ps.getParameterMetaData();
			   if(pmd!=null) {
				   int paramCount =pmd.getParameterCount();
				   for(int i = 1;i<paramCount;++i) {
					    System.out.println("paramerter Number ::"+i);
					    System.out.println("parameter name mode::"+pmd.getParameterMode(i));
					   //System.out.println("parameter type Name::" +pmd.getParameterTypeName(i));
					   System.out.println("parameter is signed::"+pmd.isSigned(i));
				  }//for
			  }//if
			  
		  }//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	}//main

}//class
