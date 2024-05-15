package controller;

import java.sql.*;
import java.util.Scanner;
import model.DBConnection;
import view.*;

public class logincheck {

    public void CLIENT12() {
        Scanner scanner = new Scanner(System.in);
        int loginfc = scanner.nextInt();
        if (loginfc == 1) {
            String query = "select * from login";
            try {
                Connection con = DBConnection.createConnection();
                main1 f = new main1(con, scanner);
                PreparedStatement preparedStatement = con.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.print("login or signup:");
                int c = scanner.nextInt();
                if (c == 1) {
                    System.out.print("Enter Your UserName: ");
                    String name = scanner.next();
                    System.out.print("Enter Password: ");
                    String pass = scanner.next();

                    while (resultSet.next()) {

                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");

                        if (username.equals(name) && password.equals(pass)) {
                            f.free();
                        }
                    }
                } else if (c == 2) {

                    System.out.print("Enter Your Name: ");
                    String username = scanner.next();
                    System.out.print("Enter Password ");
                    String password = scanner.next();

                    try {
                        String query1 = "INSERT INTO login(username,password) VALUES(?, ?)";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query1);
                        preparedStatement1.setString(1, username);
                        preparedStatement1.setString(2, password);

                        int affectedRows = preparedStatement1.executeUpdate();
                        if (affectedRows > 0) {
                            System.out.println("You Login Successfully!!");
                            f.free();
                        } else {
                            System.out.println("Failed to add You!!");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (loginfc == 2) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String query = "select * from login1";
            try {
                Connection con = DBConnection.createConnection();
                main2 fr = new main2(con, scanner);
                PreparedStatement preparedStatement = con.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.print("Login or SignUp :");
                int c = scanner.nextInt();

                if (c == 1) {
                    System.out.print("Enter Your UserName: ");
                    String name = scanner.next();
                    System.out.print("Enter Password: ");
                    String pass = scanner.next();
                    while (resultSet.next()) {
                        String username2 = resultSet.getString("username2");
                        String password2 = resultSet.getString("password2");

                        if (username2.equals(name) && password2.equals(pass)) {
                            fr.free();
                        }
                    }
                } else if (c == 2) {

                    System.out.print("Enter Your Name: ");
                    String username2 = scanner.next();
                    System.out.print("Enter Password ");
                    String password2 = scanner.next();

                    try {
                        String query1 = "INSERT INTO login1(username2,password2) VALUES(?, ?)";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query1);
                        preparedStatement1.setString(1, username2);
                        preparedStatement1.setString(2, password2);

                        int affectedRows = preparedStatement1.executeUpdate();
                        if (affectedRows > 0) {
                            System.out.println("You Login Successfully!!");
                            fr.free();
                        } else {
                            System.out.println("Failed to add You!!");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}