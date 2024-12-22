package com.gaspard.Project1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {

	static String JDBC_URL = "jdbc:postgresql://ep-hidden-flower-a59hpvly.us-east-2.aws.neon.tech/neondb?sslmode=require";
	static String DB_USER = "neondb_owner";
	static String DB_PASSWORD = "3sxrkOeG9gdc";
	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application démarrée");

	}
}
