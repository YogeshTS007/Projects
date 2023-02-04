package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	//Declaring The variables globally so that it can be accessible throughout

	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	
	//========================================================================
	
	//Taking pin number as primary key to access other tables
	
	Withdrawl(String pinnumber) {
		
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

	//Adding labels,buttons and textfields using Jlabel,jbutton and jtextfield methods
		
		JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,300,400,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw"); 
		withdraw.setBounds(355,485,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);		
		
		
		setVisible(true);
		
	}
	//========================================================================
	
	//Implementing action performed method from the action event interface to obtain the actions performed by the user

	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==withdraw) {
			String number = amount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To withdraw");
			}else{
				
	//executing SQL database queries using Con class created earlier

				try {
				Con con = new Con();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','" +number+"')";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawn Sucessfully");
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
		}else if(ae.getSource()==withdraw) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}
	}
	
	//========================================================================
	
	//executing method by main method

		public static void main(String[] args) {
		
		new Withdrawl("");
		
	}
}
	//========================================================================
