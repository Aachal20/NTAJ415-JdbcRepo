package com.nt.jdbc;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteTest {


	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			String loc =null;
			if(sc!=null) {
				System.out.println("enter  location( hyd)" );
				loc = sc.next();
			}
			//give required query to sql 
			loc="'+loc+'";
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "manager");
			//Create JDBC statement obj(vehicle)
			if(con!=null)
				st = con.createStatement();
			//prepare the sql query
			//  String query="CREATE TABLE  IRCTC_AACHAL (EMAIL VARCHAR(15) PRIMARY KEY, PASSWORD VARCHAR2(10) ,DOB DATE,LOCATION VARCHAR(20))";
			// String query = "DROP TABLE  TEMP_AACHAL1 ";
			//  String query = "INSERT INTO IRCTC_AACHAL  VALUES( 'MOZARE@.COM' ,  'AACHAL' ,  '20-AUG-1999 ',  'HYD')";
			// String query ="SELECT * FROM  IRCTC_AACHAL   ";
			// String query ="DELETE FROM IRCTC_AACHAL WHERE LO="+LOC;
			//DELET QUERY
			String query ="DELETE FROM IRCTC_AACHAL WHERE LOCATION= "+loc;
			System.out.println(query);
			//send and execute the sql query to DB s/w
			int count=0;
			if(st!=null)
				count =  st.executeUpdate(query);

			//System.out.println("count: :" +count);
			//process the result
			if(count==0)
				System.out.println("NO RECORD FOUND TO DELETE ");
			else
				System.out.println("no. of record that are effected after query execution:: " +count);
		}//try
		catch(SQLException se) {
			se.printStackTrace();

			if(se.getErrorCode()==900 && se.getErrorCode()<=999)
				System.out.println("INVALID  TBALE NAME ,COL NAME OR SQL KW");
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




