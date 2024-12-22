package com.gaspard.Project1;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    static String JDBC_URL = "jdbc:postgresql://ep-hidden-flower-a59hpvly.us-east-2.aws.neon.tech/neondb?sslmode=require";
    static String DB_USER = "neondb_owner";
    static String DB_PASSWORD = "3sxrkOeG9gdc";

    public class User {
        private int id;
        private String name;
        private String firstname;
        private String email;

        public User(int id, String name, String firstname, String email){
            this.id = id;
            this.name = name;
            this.firstname = firstname;
            this.email = email;
        }

        public int getId(){
            return id;
        }

        public String getName(){
            return name;
        }

        public String getFirstname(){
            return firstname;
        }

        public String getEmail(){
            return email;
        }
}
    @GetMapping("/GET")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connexion réussie à la base de données");
            String query = "SELECT id, name, firstname, email FROM \"user\" ";
            PreparedStatement psmt = connection.prepareStatement(query);
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String firstname = resultSet.getString("firstname");
                String email = resultSet.getString("email");
                users.add(new User(id, name, firstname, email));

            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            System.err.println("Erreur lors de la connexion ou de l'insertion des données : " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }
}
