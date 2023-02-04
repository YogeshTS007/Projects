package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {
	
	//Declaring The variables globally so that it can be accessible throughout

		String pinnumber;
		
	//========================================================================

	//Taking pin Number as primary key to access other tables

		MiniStatement(String pinnumber){
			
		this.pinnumber = pinnumber;
		
	//========================================================================
	
	//Adding labels using Jlabel class
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("BANK OF AMERICA");
		bank.setBounds(150,20,300,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,400,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
	//========================================================================

	//executing SQL database queries using Con class created earlier
	
		try {
			
			Con con = new Con();
			ResultSet rs=con.s.executeQuery("select* from login where PIN ='"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number : "+rs.getString("Card_Number").substring(0,4)+"-XXXX-XXXX-"+rs.getString("Card_Number").substring(12));
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		try {
			
			Con con = new Con();
			int bal =0;
			ResultSet rs = con.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
			while (rs.next()) {
				mini.setText(mini.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
			
				if(rs.getString("Type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}else {
					bal -=  Integer.parseInt(rs.getString("amount"));
				}
			}
			
			balance.setText("Your Current Account Balance is Rs: "+bal);
			
			
		} catch (Exception e) {
		  e.printStackTrace();		
		}
		
	//========================================================================

		
	//Adding the JFrame and making it visible
		
		setTitle("MINI STATEMENT");
		setSize(400,600);
		setLocation(20,20);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	//========================================================================

		
	}
		
	//executing the method through main class
	
	public static void main(String[] args) {
		new MiniStatement("");
	}

}
	//========================================================================

