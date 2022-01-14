package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PsDateRetriveByDateRange {

	
		public static final String RETRIVE_DATES_QUERY="SELECT PID,PNAME,DOB,DOJ,DOM FROM PERSON_DATES_INFO WHERE DOB>? AND DOB<?";
		public static void main(String[] args) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Scanner sc = null;
			try {
				sc = new Scanner(System.in);
				System.out.println();
				String sdob = null,edob=null;
				
				if(sc!=null) {
					System.out.println("Enter start range of DOB(dd-MM-yyyy");
					sdob = sc.next();
					System.out.println("Enter end range of date DOB(dd-mm-yyyy");
					edob = sc.next();
					//Converting  String Dates values to java.sql.util class object
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					
				}
			}
			catch(SQLException  se) {
				 se.printStackTrace();
				}

			catch(Exception e) {
			 e.printStackTrace();
			}

	}

}
