package com.nt.jdbc3;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class GUIScrollFrameTest extends JFrame {

  	public  GUIScrollFrameTest(){                         //constructor for one time execution
		 
  		System.out.println("GUIScrollFrameTest1:(0-param constructor (Start)");
  		
		 setTitle("GUIScrollFrameTest-Scroll Frame");
		 setSize(300,300);
		 //setLayout(new FlowLayout());
		 setLayout(new FlowLayout());
		 
		
		 setVisible(true);                                                     //close window
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 System.out.println("GUIScrollFrameTest:(0-param constructor (end)");
		 
	 }
	public static void main(String[] args) {
		  System.out.println("JFrameScrollTest1:(0-param constructor(start)");
          new  GUIScrollFrameTest();  //anonymus class
          System.out.println("end of mind method");
	}

}
