package com.bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

		//declaring the entities outside the login method to access it across the class(instance 
		// variable)
		
		JButton login,clearForm,signUp;
		JTextField cardTextField;
		JPasswordField pinTextField;
	
		//========================================================================

		Login(){
		
		//Adding Title to the JFrame and making it visible
		
		setTitle("LOGIN OR SIGN UP PAGE");
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 500);
		setVisible(true);
		setLocation(350, 300);
		
		//========================================================================
		
		//Adding Bank of America icon by importing from system resource
		
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource
		("Bank-of-America-logo.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);		
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(30, 20, 150, 100);
		add(label);
		
		
		//========================================================================
		
		//adding the title of the application
		
		JLabel text = new JLabel("Welcome to BOA ATM");
		text.setFont(new Font("Osward",Font.BOLD,40));
		text.setBounds(220, 40, 800, 40);
		add(text);
		
		//========================================================================
		
		//adding Card number text and the text box for user input
		
		
		JLabel cardNo = new JLabel("Card Number : ");
		cardNo.setFont(new Font("Raleway",Font.BOLD,20));
		cardNo.setBounds(230, 150, 300, 40);
		add(cardNo);
		 
		cardTextField = new JTextField();
		cardTextField.setBounds(400, 150, 250, 40); 
		cardTextField.setFont(new Font ("Arial",Font.BOLD,20));
		add(cardTextField);
		
		//========================================================================
		
		//adding Pin number text and the text box for user input
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(230, 220, 250, 30);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(400, 220, 250, 40); 
		pinTextField.setFont(new Font ("Arial",Font.BOLD,20));
		add(pinTextField);
		
		//========================================================================

		//adding the sing in,clear and sign up buttons
		
		login = new JButton("SIGN IN");
		login.setBounds(400,300,120,30);
		login.setBackground(Color.black);
		login.setForeground(Color.BLACK);
		login.addActionListener(this);
		add(login);
		
		clearForm = new JButton("CLEAR");
		clearForm.setBounds(530,300,120,30);
		clearForm.setBackground(Color.black);
		clearForm.setForeground(Color.BLACK);
		clearForm.addActionListener(this);
		add(clearForm);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(400,350,250,30);
		signUp.setBackground(Color.black);
		signUp.setForeground(Color.BLACK);
		signUp.addActionListener(this);
		add(signUp);
		
		//========================================================================

		
	}
	
		//assigning the buttons from user input to perform certain actions
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==clearForm) {
			
			cardTextField.setText("");
			pinTextField.setText("");
				 
		}else if(ae.getSource()==login) {
			Con con = new Con();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where Card_Number = '"+cardnumber+"'and PIN = '"+pinnumber+"'";
			try {
				ResultSet rs = con.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (ae.getSource()==signUp) {
			setVisible(false);
			new SignUp1().setVisible(true);
		}
		
		//========================================================================

	}
	public static void main(String[] args) {
		
		new Login();
	}
}

		//========================================================================
