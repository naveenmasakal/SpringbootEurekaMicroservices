package com.example.postgreeapplication;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class PostgreeapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgreeapplicationApplication.class, args);
		
//		System.out.println("Connection Started");
//		try {
//		Class.forName("org.postgresql.Driver");
//		Connection connection = null;
//		connection = DriverManager.getConnection("jdbc:postgresql://35.228.160.6/shoppingcart","dev-dbuser", "pa55word");
//		
//		System.out.println("Connected");
//
//		connection.close();
//		System.out.println("Connection closed closed");
//
//		
//		}
//		catch(Exception e) {e.printStackTrace();}
		System.out.println("XXXX Connected");
		
	}
}
