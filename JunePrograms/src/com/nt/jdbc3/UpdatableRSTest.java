package com.nt.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableRSTest {
	
	  private static final String EMP_SELECT_QUERY ="SELECT  SNO,SNAME,SADD,AVG   FROM STUDENT";
	  
	public static void main(String[] args) {
		 try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","aachal");
			        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						 ResultSet rs = st.executeQuery(EMP_SELECT_QUERY);
  	){		
         if(rs!=null) {
         	System.out.println("RS Record top to botttom");
         //	int count = 0;
         	
         	while(rs.next()) {
         	     	System.out.println( "----->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
         	}//while
         	//insert operation
         	/*rs.moveToInsertRow();
         	rs.updateInt(1,1010);
         	rs.updateString(2,"karina");
         	rs.updateString(3, "kolkatta");
         	rs.updateFloat(4,99.33f);
         	//rs.insertRow();
         	System.out.println("Record Inserted::");*/
         	
         	//Update Operation
         	/*rs.absolute(4);
         	rs.updateFloat(4, 22.33f);
         	rs.updateRow();*/
         	
         	//delete operation
         	rs.absolute(3);
         	rs.deleteRow();
         }//if
		 
}//try
catch(SQLException se) {
	 se.printStackTrace();
}
catch(Exception  e) {
	 e.printStackTrace();
}
	}

}
