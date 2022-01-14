package com.nt.jdbc3;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.swing.JFrame;

 class GUIScrollFrameTest1 extends JFrame implements ActionListener{


	public  GUIScrollFrameTest1(){                         //constructor for one time execution
			 
	  		System.out.println("GUIScrollFrameTest1:(0-param constructor (Start)");
	  		
			 setTitle("GUIScrollFrameTest-Scroll Frame");
			 setSize(300,300);
	         setLayout(new FlowLayout());
			 
			 //add componenet
			 
			  JLabel  lsno  = new JLabel("sno");
			   add(lsno);
			   JTextField tsno =  new JTextField(10);
			   add(tsno);
			 setVisible(true);  
			 
			 JLabel  lsname  = new JLabel("sname");
			   add(lsname);
			   JTextField tsname =  new JTextField(10);
			   add(tsname);
			   
			   JLabel laddr = new JLabel("saddrs");
			   add(laddr);
			   JTextField taddr =  new JTextField(10);
			   add(taddr);
			   
			   
			   JLabel lavg = new JLabel("student avg");
			   add(lavg);
			   JTextField tavg =  new JTextField(10);
			   add(tavg);
			   
			   Button bFirst = new  Button("First");
			   Button bNext = new  Button("Next ");
			   Button bPrivious  = new  Button("Privious");
			   Button bLast = new  Button("Last");
			   add(bFirst);
			   add(bNext);
			   add(bPrivious);
			   add(bLast);
			   
			   //Register and activate ActionListener fo all four buttons or componenet
			      bFirst.addActionListener(this);
			      bNext.addActionListener(this);  //current class obj as a action listener
			      bPrivious.addActionListener(this);
			      bLast.addActionListener(this);
			   
			   
			   
			   
			   
			 setVisible(true);  
			 
			 //close window
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //try comment and uncoment see magic
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 System.out.println("GUIScrollFrameTest:(0-param constructor (end)");
			 
		 }
	        //private  void intializedJDBS() {
	        	//System.out.println("GUIScrollFrameTest");
	        	//try {
	        		//establish the connection
	        		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"aachal");
	        		//create prepared statement obj
	        	//	PreparedStatement ps=con.prepareStatement(GET_STUDENTS_QUERY,
	        	//			                                                                                       ResultSet.TYPE_SCROLL_SENSITIVE,
	        		//		                                                                                             ResultSet.CONCUR_UPDATABLE);
	        		
	        		//PrepareStatement ps= con.prepareStatement(GET_STUDENTS_QUERY,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        		//PREPARE RS SCROLLABE OBJECT
	        		//rs=ps.executeQuery();
	        	
	        	//}//try
	        	//catch(SQLException se) {
	        	//	se.printStackTrace();
	        //	}
	        	//catch(Exception e) {
	        	//	e.printStackTrace();
	        	//}
	     //   }//intialize jdbc
		public static void main(String[] args) {
			  System.out.println("JFrameScrollTest1:(0-param constructor(start)");
	          new   GUIScrollFrameTest1(); //anonymus class
	          System.out.println("end of main method");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("GUIScrollFrameTest actionPerformed()");
			//boolean flag=false;
		//	if(e.getSource()==bFirst) {
			//	try {
				//	flag=true;
				//	System.out.println();
			//	}
			//	catch(SQLException se){
				//	se.printStackTrace();
			//	}
			//}
		//	else if(e.getSource()==bNext) {
			//	System.out.println("next button is clickd");
		//	}
		//	try {
				
			}
		}

	
		

	


