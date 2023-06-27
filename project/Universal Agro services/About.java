/* =========================================================================
 * Class	: About
 * ========================================================================= */

import java.sql.*;
import java.util.Date;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;
import java.awt.print.*;
 
class About extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12; 
	JButton b1; 
	Container c1=getContentPane();
	Font f1 = new Font("Bell MT",Font.BOLD,22);
	Font f2 = new Font("Bell MT",Font.BOLD,16);
	public About()
	{
		super("About");    setLayout(null);
	     c1.setBackground(Color.white);
	    
		l1 = new JLabel("Project Name : ");				l1.setBounds(10,10,200,30);
		l2 = new JLabel("Universal Agro Services 1.0"); l2.setBounds(150,10,280,30);	
		l3 = new JLabel("Project Group : ");			l3.setBounds(10,60,180,30);	
		l4 = new JLabel("1. Monika Bafna");				l4.setBounds(150,70,200,30);
		l5 = new JLabel("2. Pranali Sonje");			l5.setBounds(150,90,200,30);
		
		
		l6 = new JLabel("From : ");		l6.setBounds(10,120,200,30);
		l7 = new JLabel("  TYBSc(Comp. Sci.)");			l7.setBounds(150,120,200,30);
		l8 = new JLabel("K.K.W. College of Atrs, Commerce & Science , Pimpalgaon (B.)");	l8.setBounds(10,150,500,30);
		l9 = new JLabel(" ");							l9.setBounds(110,140,150,30);
		l10 = new JLabel("_________________________________________"+
						"__________________________________________________________");	l10.setBounds(0,190,600,30);
		l12 = new JLabel("_________________________________________"+
						"__________________________________________________________");	l12.setBounds(0,35,600,30);
		
		l1.setFont(f2);   l2.setFont(f1);
		l3.setFont(f2);   l4.setFont(f2);
		l5.setFont(f2);   l6.setFont(f2);
		l7.setFont(f2);
		l8.setFont(f2);
		
		 l10.setForeground(Color.BLUE);	
		 l12.setForeground(Color.BLUE);	
		b1 = new JButton("Ok");	b1.setBounds(180,240,80,30);
		
		c1.add(l1);c1.add(l2);c1.add(l3);c1.add(l4);c1.add(l5);c1.add(l6);
		c1.add(l7);
		c1.add(l8);c1.add(l9);c1.add(l10);c1.add(b1);
		c1.add(l12);
		
		b1.addActionListener(this);
		setSize(500,320);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	 	if(ae.getSource()==b1)
	 	{
			dispose();
	 	}
	}
 	/* public static void main(String args[])
 	  {
 	  	 abut a=new abut();
 	  }*/	 
 }