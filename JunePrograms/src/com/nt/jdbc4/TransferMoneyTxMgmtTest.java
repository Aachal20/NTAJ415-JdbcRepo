package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransferMoneyTxMgmtTest {

	public static void main(String[] args) {
		
		long srcAcno = 0,desAcno=0;
		double amount = 0.0;
		try(Scanner scn =  new Scanner(System.in)){

          //Read Inputs
			if(scn!=null) {
				    System.out.println("Enter src account number::");
			     	srcAcno = scn.nextLong();
			        System.out.println("Enter dest account number::");
		       	   desAcno = scn.nextLong();
			        System.out.println("Enter amount to transfer:::");
			        amount = scn.nextDouble();
		}//if
		}//try
		catch(Exception e ) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system" ,"aachal");
			Statement st = con.createStatement();
				){
			  if(st!=null) {
				           //add querys to the batch
				          //for withdraw operation
				            st.addBatch("Update JDBC_ACCOUNT set balance = balance-"+amount+" where acno="+srcAcno);
			    	      //for deposit  operation
				          st.addBatch("Update JDBC_ACCOUNT set balance = balance"+amount+" where acno="+desAcno);
			           	//execute the batch
			            int result[]=	st.executeBatch();
			 
		         	 //process the result from TxMgmt
			            boolean flag = true;
			            for(int i = 0;i<result.length;++i) {
			            	if(result[i]==0) {
			            		flag = false;
			            		break;
			            	}
			            }
			            if(flag==true) {
			            	con.commit();
			               System.out.println("Tx Commited ,Money Transfered");
			            }
			            else  {
			            	con.rollback();
			               System.out.println("Tx Rolleback  ,Money Not Transfered");
			            }
			 
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


