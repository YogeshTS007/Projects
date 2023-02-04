package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import com.toedter.calendar.*;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp1 extends JFrame implements ActionListener {
	
	//Declaring The variables globally so that it can be accessible throughout
	
	long random;
	JTextField 
	nameTextField,fnameTextField,emailTextField,addressTextField,
	cityTextField,stateTextField,pinTextField;
	JButton next;
	JRadioButton male,female,others,married,unmarried;
	JDateChooser dateChooser;
	ButtonGroup genderGroup,maritalGroup;
	
	//========================================================================
		
	SignUp1() { 
		
	//Adding the JFrame and making it visible
	 
		setLayout(null);
		setTitle("PERSONAL DETAILS PAGE");
		getContentPane().setBackground(Color.white);		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	//========================================================================

		
	//using random method from util package to obtain card number	
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong()%9000+1000L));
		
	//========================================================================

	//Adding labels using Jlabel class
	
		JLabel formno = new JLabel("APPLICATION FORM NO : "+ random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1 : Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name : ");
		name.setFont(new Font("Raleway",Font.BOLD,22));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		JLabel fname = new JLabel("Father's Name : ");
		fname.setFont(new Font("Raleway",Font.BOLD,22));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		JLabel dob = new JLabel("Date Of Birth : ");
		dob.setFont(new Font("Raleway",Font.BOLD,22));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		JLabel gender = new JLabel("Gender : ");
		gender.setFont(new Font("Raleway",Font.BOLD,22));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		JLabel email = new JLabel("Email-ID : ");
		email.setFont(new Font("Raleway",Font.BOLD,22));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		JLabel marital = new JLabel("Marital Status : ");
		marital.setFont(new Font("Raleway",Font.BOLD,22));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		JLabel address = new JLabel("Address : ");
		address.setFont(new Font("Raleway",Font.BOLD,22));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Raleway",Font.BOLD,22));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		JLabel state = new JLabel("State : ");
		state.setFont(new Font("Raleway",Font.BOLD,22));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		JLabel pinCode = new JLabel("Pincode : ");
		pinCode.setFont(new Font("Raleway",Font.BOLD,22));
		pinCode.setBounds(100, 590, 200, 30);
		add(pinCode);
		
	//========================================================================
		
	//Adding textfields using JTextfield class
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Arial",Font.BOLD,14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Arial",Font.BOLD,14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);			
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Arial",Font.BOLD,14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Arial",Font.BOLD,14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Arial",Font.BOLD,14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Arial",Font.BOLD,14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);
		
	//adding date chooser by using external jar file
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setForeground(new Color (105,105,105));
		add(dateChooser);
		
	//========================================================================
		
	//adding buttons using Jradiobutton class	
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,120,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		others = new JRadioButton("Others");
		others.setBounds(630,390,100,30);
		others.setBackground(Color.WHITE);
		add(others);
		
		maritalGroup = new ButtonGroup();
		
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(others);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);		
	}
	
	//========================================================================
	
	//Implementing action performed method from the action event interface to obtain the actions performed by the user
	
	public void actionPerformed(ActionEvent ae) {
		
		String formno = ""+random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}else if (unmarried.isSelected()) {
			marital = "Unmarried";
		}else if (others.isSelected()) {
			marital = "Others";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText(); 
	
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is required" );
			}if(fname.equals("")) {
				JOptionPane.showMessageDialog(null,"Please provide Father's Name" );
			}if(dob.equals("")) {
				JOptionPane.showMessageDialog(null,"Date of birth is required" );
			}if(email.equals("")) {
				JOptionPane.showMessageDialog(null,"email is required" );
			}if(address.equals("")) {
				JOptionPane.showMessageDialog(null,"address is required" );
			}if(city.equals("")) {
				JOptionPane.showMessageDialog(null,"city field cannot be empty" );
			}if(pin.equals("")) {
				JOptionPane.showMessageDialog(null,"pin is required" );
			}if(state.equals("")) {
				JOptionPane.showMessageDialog(null,"State field cannot be empty" );
			}else {
				
	//========================================================================
				
	//executing SQL database queries using Con class created earlier

				Con c = new Con();
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','" +dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUp2(formno).setVisible(true);
			}
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}
	
	//========================================================================
	
	//executing method by main method
	
	public static void main(String[] args) {
		
		new SignUp1();			
	}

}
	//========================================================================

