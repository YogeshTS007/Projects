package com.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{
	
	//Declaring The variables globally so that it can be accessible throughout
	
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinnumber;
	
	//========================================================================

	//Taking pin number as primary key to access other tables

	 Transactions(String pinnumber) {
		 
		this.pinnumber =pinnumber;
		
	//========================================================================

	//Adding the JFrame and making it visible

		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setLayout(null);
		
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

	//Adding labels and buttons using Jlabel and jbutton class

		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Withdrawl");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		setVisible(true);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355,450,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("PIN Change");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355,485,150,30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setVisible(true);
	}

	 //========================================================================

	//Implementing action performed method from the action event interface to obtain the actions performed by the user

	 @Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==exit) {
				System.exit(0);
			}else if (ae.getSource()==deposit) {
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);
			}else if (ae.getSource()==withdrawl) {
				setVisible(false);
				new Withdrawl(pinnumber).setVisible(true);
			}else if(ae.getSource()==fastcash) {
				setVisible(false);
				new FastCash(pinnumber).setVisible(true);
			}else if (ae.getSource()==pinchange) {
				setVisible(false);
				new PinChange(pinnumber).setVisible(true);
			}else if (ae.getSource()==balanceenquiry) {
				setVisible(false);
				new BalanceEnquiry(pinnumber).setVisible(true);
			}else if (ae.getSource()==ministatement) {
				new MiniStatement(pinnumber).setVisible(true);
			}
		}

	 //========================================================================
	 
	//executing method by main method

	public static void main(String[] args) {
		new Transactions("");
		
	}
}
	//========================================================================
