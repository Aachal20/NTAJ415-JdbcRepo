package com.nt.jdbc;
import java.sql.*;
public class SelectTest_MySql {
	 public static void main(String[] args) throws Exception{
		    
		   Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NTAJ415DB" ,"root" , "achal");
	       
			
			 Statement st = con.createStatement();
			 
			 ResultSet  rs = st.executeQuery("SELECT * FROM student");
			 
			 while(rs.next()!=false){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getFloat(4));			
			 }
		     rs.close();
			 st.close();
		     con.close();
			 
}

}
