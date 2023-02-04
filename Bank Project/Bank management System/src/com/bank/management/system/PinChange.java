package com.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
	
	//Declaring The variables globally so that it can be accessible throughout
	
	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;

	//========================================================================
	
	//Taking pin Number as primary key to access other tables
	
		PinChange(String pinnumber){
		this.pinnumber=pinnumber;	
		
	//========================================================================

		setLayout(null);
		
	//adding Image Icon of ATM through system resource through classloader

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
	//========================================================================
		
	//Adding labels using Jlabel class

		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN : ");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);		
		
		JLabel repintext = new JLabel("Re-Enter New PIN : ");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		image.add(repintext);
		
	//========================================================================
		
	//adding password field and button using jpasswordfield and jbutton classes	
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
	//========================================================================
		
	//Adding the JFrame and making it visible
	
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	//========================================================================

	}
	
	//implementing action performed method and checking if the entered passwords match or not
		
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
			
		try {
			String npin = pin.getText();
			String rpin = repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Please check and re-enter PIN");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter new PIN");
				return;
			}if(rpin.equals("")){
				JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
				return;
			}
	
	//========================================================================
			
	//executing SQL database queries using Con class created earlier

			
			Con con = new Con();
			String query1 = "update bank set PIN = '"+rpin+"'where PIN='"+pinnumber+"'";
			String query2 = "update login set PIN = '"+rpin+"'where PIN='"+pinnumber+"'";
			String query3 = "update signup3 set PIN = '"+rpin+"'where PIN='"+pinnumber+"'";

			con.s.executeUpdate(query1);
			con.s.executeUpdate(query2);
			con.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed successfully");
			setVisible(false);
			new Transactions(rpin).setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	//========================================================================

	//executing the method using main class
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
	//========================================================================
