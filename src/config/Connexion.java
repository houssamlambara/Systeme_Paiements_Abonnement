package config;

import java.sql.*;
import java.sql.DriverManager;
import java.util.UUID;

public class Connexion {

    private String url = "jdbc:mysql://localhost:3306/systeme_abonnement";
        private String usertName = "root";
        private String pass = "root";

        public static Connexion instance = null;
        private Connection connection = null;

        public static Connexion getInstance() {
            if (instance == null)
                instance = new Connexion();
            return instance;
        }

        private Connexion() {
            try {
                connection = DriverManager.getConnection(url, usertName, pass);
                System.out.println("Database connected successfully");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public Connection getConnection() {
            return connection;
        }
    }
