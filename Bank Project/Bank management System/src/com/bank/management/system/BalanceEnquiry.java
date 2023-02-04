package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
	
	//Declaring The variables globally so that it can be accessible throughout

	JButton back;
	String pinnumber;
	
	//========================================================================

	//Taking pin Number as primary key to access other tables
	
	BalanceEnquiry(String pinnumber){
		
		this.pinnumber=pinnumber;
		
	//========================================================================

	//adding Image Icon of ATM through system resource through classloader
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource
		("atm.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
	//========================================================================
	
	//adding the back button
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
	
	//========================================================================

	//fetching the balance from MySQL database 
		
		Con c = new Con();
		int balance = 0;
		try {
			
			ResultSet rs = c.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
			while(rs.next()){
				if(rs.getString("Type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -=  Integer.parseInt(rs.getString("amount"));
				}
				
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170,300,400,30);
		image.add(text);
		
	//========================================================================

		
	//Adding Title to the JFrame and making it visible
		
		setSize(900,900);
		setLocation(300,0);
		setLayout(null);
		setTitle("CHECK BALANCE");
		setVisible(true);
		
	//========================================================================
		
	}
	
	//Implementing action performed method from the action event interface to obtain the actions perferformed by the user
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
		
	}
	
	//========================================================================

	//method execution through main class
	
	public static void main(String[] args) {
		
		new BalanceEnquiry("");
		
	}
}

	//========================================================================
