package com.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	//Declaring The variables globally so that it can be accessible throughout

	JButton rs100,rs500,rs1k,rs2k,rs5k,rs10k,back;
	String pinnumber;
	
	//========================================================================

	//Taking pin Number as primary key to access other tables

	 FastCash(String pinnumber) {
		 
		this.pinnumber =pinnumber;
		
	//========================================================================

	//Adding the JFrame and making it visible

		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		
	//========================================================================

	//adding Image Icon of ATM through system resource through classloader
	 
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource
		("atm.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
	//========================================================================
		
	//adding the text label Through jlabel class
	 
		JLabel text = new JLabel("Please Select Withdrawl Amount");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
	//========================================================================
		
	//adding the buttons to withdraw cash instantly	
		
		rs100 = new JButton("Rs 100");
		rs100.setBounds(170,415,150,30);
		rs100.addActionListener(this);
		image.add(rs100);
		
		rs500 = new JButton("Rs 500");
		rs500.setBounds(355,415,150,30);
		rs500.addActionListener(this);
		image.add(rs500);
		
		rs1k = new JButton("Rs 1000");
		rs1k.setBounds(170,450,150,30);
		rs1k.addActionListener(this);
		image.add(rs1k);
		setVisible(true);
		
		rs2k = new JButton("Rs 2000");
		rs2k.setBounds(355,450,150,30);
		rs2k.addActionListener(this);
		image.add(rs2k);
		
		rs5k = new JButton("Rs 5000");
		rs5k.setBounds(170,485,150,30);
		rs5k.addActionListener(this);
		image.add(rs5k);
		
		rs10k = new JButton("Rs 10000");
		rs10k.setBounds(355,485,150,30);
		rs10k.addActionListener(this);
		image.add(rs10k);
		
	//========================================================================

	//adding button using jButton class
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
	//========================================================================

		setVisible(true);
		
	}
	 
	//Implementing action performed method from the action event interface to obtain the actions perferformed by the user

	 @Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==back) {
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}else  {
				String amount = ((JButton)ae.getSource()).getText().substring(3);
				
	//========================================================================
				
	//executing SQL database queries using Con class created earlier


				Con c = new Con();
				try {
					
					ResultSet rs = c.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
					int balance =0;
					while(rs.next()){
						if(rs.getString("Type").equals("Deposit")) {
							balance += Integer.parseInt(rs.getString("amount"));
						}else {
							balance -=  Integer.parseInt(rs.getString("amount"));
						}
						
					}
					
	//========================================================================
	
	//action performed
					
					if(ae.getSource() != back &&  balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
					}
					
	//========================================================================
			
	//executing SQL database queries using Con class created earlier
				
				
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
				}catch (Exception e) {
					e.printStackTrace();				
				}
				
			}
		}
	 
	//========================================================================
	 
	 //method execution through main class

	public static void main(String[] args) {
		new FastCash("");
		
	}
	
}
	//========================================================================

