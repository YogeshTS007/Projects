package com.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener {
	
	//Declaring The variables globally so that it can be accessible throughout
	
	JTextField panNo1TextField,aadharTextField;
	JButton next;
	JRadioButton syes,sno,eno,eyes;
	ButtonGroup seniorGroup,existingGrp;
	JComboBox occupation1,religion1,education1,income1,category1;
	String formno;
	
	//========================================================================
	
	//Taking formno as primary key to access other tables
	
	SignUp2(String formno) { 
		 
		this.formno = formno;
	
	//========================================================================
		
	//Adding the JFrame and making it visible

		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		getContentPane().setBackground(Color.white);		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	//========================================================================

	//Adding labels using Jlabel class
		 	
		JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion : ");
		religion.setFont(new Font("Raleway",Font.BOLD,22));
		religion.setBounds(100, 140, 200, 30);
		add(religion);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		religion1 = new JComboBox(valReligion);
		religion1.setBounds(350, 145, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion1);
		
		JLabel category = new JLabel("Category Name : ");
		category.setFont(new Font("Raleway",Font.BOLD,22));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String valCategory [] = {"General","3A","3B","OBC","SC","ST","Others"};
		category1 = new JComboBox(valCategory);
		category1.setBounds(350, 195, 400, 30);
		category1.setBackground(Color.WHITE);
		add(category1);
		
		JLabel income = new JLabel("Income : ");
		income.setFont(new Font("Raleway",Font.BOLD,22));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String incomeCategory [] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000","Above 10,00,000","HNI"};
		income1 = new JComboBox(incomeCategory);
		income1.setBounds(350, 245, 400, 30);
		income1.setBackground(Color.WHITE);
		add(income1);
		
		JLabel education = new JLabel("Educational ");						
		education.setFont(new Font("Raleway",Font.BOLD,22));
		education.setBounds(100, 290, 200, 30);
		add(education);
		
		JLabel qualification = new JLabel("Qualification : ");						
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
			
		String educationValues [] = {"Non-Graduate","Graduate","Post Graduate","Doctrate","Others"};
		education1 = new JComboBox(educationValues);
		education1.setBounds(350, 315, 400, 30);
		education1.setBackground(Color.WHITE);
		add(education1);
		
		JLabel occupation = new JLabel("Occupation : ");
		occupation.setFont(new Font("Raleway",Font.BOLD,22));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
		String occupationValues [] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
		occupation1 = new JComboBox(occupationValues);
		occupation1.setBounds(350, 395, 400, 30);
		occupation1.setBackground(Color.WHITE);
		add(occupation1);
		
		JLabel panNo = new JLabel("PAN No : ");
		panNo.setFont(new Font("Raleway",Font.BOLD,22));
		panNo.setBounds(100, 440, 200, 30);
		add(panNo);
		
	//========================================================================

	//adding textfields using jtextfield class
		
		panNo1TextField = new JTextField();
		panNo1TextField.setFont(new Font("Arial",Font.BOLD,14));
		panNo1TextField.setBounds(350, 445, 400, 30);
		add(panNo1TextField);
		
		JLabel aadharNo = new JLabel("Aadhar No : ");
		aadharNo.setFont(new Font("Raleway",Font.BOLD,22));
		aadharNo.setBounds(100, 490, 200, 30);
		add(aadharNo);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Arial",Font.BOLD,14));
		aadharTextField.setBounds(350, 495, 400, 30);
		add(aadharTextField);	
		
	//========================================================================

		JLabel seniorCitizen = new JLabel("Senior Citizen : ");
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD,22));
		seniorCitizen.setBounds(100, 540, 200, 30);
		add(seniorCitizen);
		
	//adding buttons using jbutton class

		syes = new JRadioButton("Yes");
		syes.setBounds(360, 545, 200, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 545, 300, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		seniorGroup = new ButtonGroup();
		seniorGroup.add(syes);
		seniorGroup.add(sno);
				
		JLabel existingAcc = new JLabel("Existing Account : ");
		existingAcc.setFont(new Font("Raleway",Font.BOLD,22));
		existingAcc.setBounds(100, 590, 300, 30);
		add(existingAcc);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(360, 595, 300, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 595, 400, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		existingGrp = new ButtonGroup();
		existingGrp.add(eno);
		existingGrp.add(eyes);
			
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(670,660,80,30);
		next.addActionListener(this);
		add(next);		
	}
	
	//========================================================================
	
	//Implementing action performed method from the action event interface to obtain the actions performed by the user

	public void actionPerformed(ActionEvent ae) {
		
		String sreligion   = (String) religion1.getSelectedItem();
		String scategory   = (String) category1.getSelectedItem();
		String sincome     = (String) income1.getSelectedItem();
		String seducation  = (String) education1.getSelectedItem();
		String soccupation = (String) occupation1.getSelectedItem();
		String span 	   =  panNo1TextField.getText();
		String saadhar	   =  aadharTextField.getText();
		String seniorCitizen = null;
		if(syes.isSelected()) {
			seniorCitizen = "Yes";
		}else if (sno.isSelected()) {
			seniorCitizen = "No";
		}
		String existingAcc = null;
		if(eyes.isSelected()) {
			existingAcc = "Yes";
		}else if(eno.isSelected()) {
			existingAcc = "No";
		}
		
	//========================================================================

	//executing SQL database queries using Con class created earlier

		try {
		Con c = new Con();
		String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','" +sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingAcc+"')";
		c.s.executeUpdate(query);
		
		setVisible(false);
		new SignUp3(formno).setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//========================================================================

	//executing method by main method

	
	public static void main(String[] args) {
		
		new SignUp2("") ;
				
	}

}
	//========================================================================

