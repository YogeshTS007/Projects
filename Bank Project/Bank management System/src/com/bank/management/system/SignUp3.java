package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener {
	
	//Declaring The variables globally so that it can be accessible throughout
	
	JRadioButton savingAcc,reccuringAcc,currentAcc,fixedAcc;
	ButtonGroup accountGroup;
	JCheckBox atmCard,intBank,mobBank,Esms,cBook,estat,declare;
	JButton submit,cancel;
	String formno;
	
	//========================================================================

	//Taking formno as primary key to access other tables
	
	public SignUp3(String formno) {
		
		this.formno=formno;
		
	//========================================================================

	//Adding the JFrame and making it visible

		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		setTitle("ACCOUNT DETAILS");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
	//========================================================================
		
	//Adding labels using Jlabel class
		
		JLabel AcDetails = new JLabel("Page 3 : Account Details");
		AcDetails.setFont(new Font("Raleway",Font.BOLD,22));
		AcDetails.setBounds(280,40,400,40);
		add(AcDetails);
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font ("Raleway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
	//========================================================================
		
	//adding buttons using jbutton class
		
		savingAcc= new JRadioButton("Saving Account");
		savingAcc.setFont(new Font("Raleway",Font.BOLD,16));
		savingAcc.setBackground(Color.WHITE);
		savingAcc.setBounds(100,180,250,20);
		add(savingAcc);
		
		fixedAcc= new JRadioButton("Fixed Account");
		fixedAcc.setFont(new Font("Raleway",Font.BOLD,16));
		fixedAcc.setBackground(Color.WHITE);
		fixedAcc.setBounds(350,180,250,20);
		add(fixedAcc);
		
		currentAcc= new JRadioButton("Current Account");
		currentAcc.setFont(new Font("Raleway",Font.BOLD,16));
		currentAcc.setBackground(Color.WHITE);
		currentAcc.setBounds(100,220,250,20);
		add(currentAcc);
		
		reccuringAcc= new JRadioButton("Reccuring Deposit Account");
		reccuringAcc.setFont(new Font("Raleway",Font.BOLD,16));
		reccuringAcc.setBackground(Color.WHITE);
		reccuringAcc.setBounds(350,220,350,20);
		add(reccuringAcc);
		
		accountGroup = new ButtonGroup();
		accountGroup.add(savingAcc);
		accountGroup.add(fixedAcc);
		accountGroup.add(currentAcc);		
		accountGroup.add(reccuringAcc);
		
		//========================================================================
		
		//Adding labels using Jlabel class
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font ("Raleway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-3174");
		number.setFont(new Font ("Raleway",Font.BOLD,22));
		number.setBounds(330,300,400,30);
		add(number);
		
		JLabel carddetail = new JLabel("Your 16 Digit Card Number");
		carddetail.setFont(new Font ("Raleway",Font.BOLD,12));
		carddetail.setBounds(100,330,400,20);
		add(carddetail);
		
		JLabel pin = new JLabel("PIN  ");
		pin.setFont(new Font ("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font ("Raleway",Font.BOLD,22));
		pnumber.setBounds(330,370,400,30);
		add(pnumber);
		
		JLabel pindetail = new JLabel("Your 4 Digit PIN Number");
		pindetail.setFont(new Font ("Raleway",Font.BOLD,12));
		pindetail.setBounds(100,400,400,20);
		add(pindetail);
		
		JLabel services = new JLabel("Services Required ");
		services.setFont(new Font ("Raleway",Font.BOLD,22));
		services.setBounds(100,450,400,30);
		add(services);
		
	//========================================================================
		
	//adding checkboxes using Jcheckbox class

		atmCard = new JCheckBox("ATM Card");
		atmCard.setBackground(Color.white);
		atmCard.setFont(new Font("Raleway",Font.BOLD,16));
		atmCard.setBounds(100,500,200,30);
		add(atmCard);
		
		intBank = new JCheckBox("Internet Banking");
		intBank.setBackground(Color.white);
		intBank.setFont(new Font("Raleway",Font.BOLD,16));
		intBank.setBounds(350,500,200,30);
		add(intBank);
		
		mobBank = new JCheckBox("Mobile Banking");
		mobBank.setBackground(Color.white);
		mobBank.setFont(new Font("Raleway",Font.BOLD,16));
		mobBank.setBounds(100,550,200,30);
		add(mobBank);
		
		Esms = new JCheckBox("Email And SMS Alerts");
		Esms.setBackground(Color.white);
		Esms.setFont(new Font("Raleway",Font.BOLD,16));
		Esms.setBounds(350,550,400,30);
		add(Esms);
		
		cBook = new JCheckBox("Cheque Book");
		cBook.setBackground(Color.white);
		cBook.setFont(new Font("Raleway",Font.BOLD,16));
		cBook.setBounds(100,600,200,30);
		add(cBook);
		
		estat = new JCheckBox("E-Statement");
		estat.setBackground(Color.white);
		estat.setFont(new Font("Raleway",Font.BOLD,16));
		estat.setBounds(350,600,200,30);
		add(estat);
		
		declare = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge ");
		declare.setBackground(Color.white);
		declare.setFont(new Font("Raleway",Font.BOLD,16));
		declare.setBounds(100,680,800,30);
		add(declare);

	//========================================================================

	//adding buttons using jbutton class

		submit = new JButton("Submit");
		submit.setBackground(Color.WHITE);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.WHITE);
		cancel.setForeground(Color.BLACK);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);

	}
	
	//========================================================================
	
	//Implementing action performed method from the action event interface to obtain the actions performed by the user
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==submit) {
			
			String accountType = null;
			if(savingAcc.isSelected()) {
				accountType = "Saving Account";
			}else if (fixedAcc.isSelected()) {
				accountType="Fixed Deposit Account";
			}else if(currentAcc.isSelected()) {
				accountType="Current Account";
			}else if(reccuringAcc.isSelected()) {
				accountType ="Reccuring Deposit Account";
			}
	
	//========================================================================
			
	//using random method from util package to obtain card number	

			Random random = new Random();
			String cardnumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			String pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
			
	//========================================================================

			String facility ="";
			if(atmCard.isSelected()) {
				facility = facility+" ATM Card";
			}else if(intBank.isSelected()) {
				facility = facility+" Internet Banking";
			}else if (mobBank.isSelected()) {
				facility = facility+" Mobile Banking";
			}else if (Esms.isSelected()) {
				facility = facility+" Email And SMS Alerts";
			}else if (cBook.isSelected()) {
				facility=facility+" Cheque Book";
			}else if(estat.isSelected()) {
				facility=facility+" E-Statement";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null,"Account type is Required");
	
	//========================================================================
					
	//executing SQL database queries using Con class created earlier

				}else {
					Con con = new Con();
					String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','" +pinnumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','" +pinnumber+"')";
					con.s.executeUpdate(query1);
					con.s.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber+" PIN : "+pinnumber);
				
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
	//========================================================================
			
	//action performed

		}else if (ae.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
		
		}
		
	}

	//========================================================================
	
	//executing method by main method
	
	public static void main(String[] args) {
		
		new SignUp3("");
	}
}
	//========================================================================

