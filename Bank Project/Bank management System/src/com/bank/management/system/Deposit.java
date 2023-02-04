package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	
	//Declaring The variables globally so that it can be accessible throughout

	JTextField amount;
	JButton deposit,back;
	String pinnumber;
	
	//========================================================================

	//Taking pin Number as primary key to access other tables
	
	Deposit(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
	//========================================================================

	//Adding the JFrame and making it visible

		setLayout(null);
		setUndecorated(true);
		setSize(900,900);
		setLocation(300,0);
		
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

		
	//adding the text label Through jlabel class
		
		JLabel text = new JLabel("Enter The Amount You Want To Deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,300,400,20);
		image.add(text);
		
	//========================================================================

	//Adding the text fields by jtextfield class
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		deposit = new JButton("Deposit"); 
		deposit.setBounds(355,485,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
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

		if(ae.getSource()==deposit) {
			String number = amount.getText();
			Date date = new Date();
			
	//========================================================================

			
	//executing SQL database queries using Con class created earlier
			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
			}else{
				try {
				Con con = new Con();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','" +number+"')";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Sucessfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
				}
	//========================================================================
			
	//action performed

		}else if (ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	//========================================================================

	//method execution through main class

		public static void main(String[] args) {
		
		new Deposit("");
		
	}

}

	//========================================================================

