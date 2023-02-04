package com.bank.management.system;

import java.sql.*;

	//Java Database Connectivity - JDBC class 

public class Con {
	
	Connection c;
	Statement s;
	
	public Con() {
		
		try {			
			
			c = DriverManager.getConnection
				("jdbc:mysql:///bankmanagementsystem","root","yogesh@007");
			
			s = c.createStatement();
			
			}catch(Exception e){
			
			System.out.println(e);
			
		}
	}
}
	
	//========================================================================