package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import controller.client;
import controller.clientDao;
import controller.freelancerDao;

public class clientinsert {
    // public clientinsert(Connection connection, Scanner scanner) {
    //     

    // }
    Scanner sc = new Scanner(System.in);
    clientDao dao = new clientDao();

    public clientinsert(Connection con, Scanner sc) {
        //TODO Auto-generated constructor stub
    }

    public void insertclient1() {
        System.out.println("Add client");
        System.out.println("Enter client name");
        String name = sc.next();
        System.out.println("Enter Your Work Title");
        String work = sc.next();
        System.out.println("Enter Your ");
        String purpose = sc.next();
        System.out.println("Enter your phone number");
        String ph_no = sc.next();
        client st = new client(name, work, purpose, ph_no);
        boolean ans = dao.insertclient(st);
        if (ans)
            System.out.println("Record inserted Successfully!!!");
        else
            System.out.println("something went wrong, please try again");

    }

    public void getprofileclient() {
        System.out.println("Get Client based on Id");
        System.out.println("enter Your Client_Id");
        int roll = sc.nextInt();
        boolean f = dao.showclientById(roll);
        if (!f)
            System.out.println("client with this id is not available in our system");
    }

    public void Deleteclient() {
        System.out.println("Delete your client Account");
        System.out.println("enter id to delete");
        int id = sc.nextInt();
        boolean ff = dao.delete(id);
        if (ff)
            System.out.println("Record deleted successfully...");
        else
            System.out.println("Something went wrong");
    }

    public void updateclient() {
        System.out.println("Update the client Details");

        System.out.println("enter id number");
        int rnum = sc.nextInt();
        System.out.println("Enter new work");
        String sname = sc.next();
        System.out.println("Enter new purpose");
        String spurpose = sc.next();
        client std = new client();
        std.setName(sname);
        boolean flag = dao.update(rnum, sname, spurpose, std);
        if (flag)
            System.out.println("Work title and Purpose updated successfully");
        else
            System.out.println("Something went wrong...");
    }

public  void bookAppointment(clientDao dao, freelancerDao dao1, Connection connection, Scanner scanner) {
        System.out.print("Enter client Id: ");
        int clientId = scanner.nextInt();
        System.out.print("Enter freelancer Id: ");
        int freelancerId = scanner.nextInt();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();
        if (dao.getclientById(clientId) && dao1.getfreelancerById(freelancerId)) {
            if (checkDoctorAvailability(freelancerId, appointmentDate, connection)) {
                String appointmentQuery = "INSERT INTO appointments(client_id, freelancer_id, appointment_date) VALUES(?, ?, ?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1, clientId);
                    preparedStatement.setInt(2, freelancerId);
                    preparedStatement.setString(3, appointmentDate);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("That's Great Appointment Booked !");
                        System.out
                                .println("That's The Freelancer Take Your Work And Finshed Before Your Assiged Date!");
                                System.out.println("Update the client Details");

                        System.out.println("enter id number");
                        int rnum1 = scanner.nextInt();
                        System.out.println("Enter new work");
                        String sname12 = scanner.next();
                        System.out.println("Enter new purpose");
                        String spurpose1 = scanner.next();
                        client std12 = new client();
                        std12.setName(sname12);
                        boolean flag12 = dao.update(rnum1, sname12, spurpose1, std12);
                        if (flag12)
                            System.out.println("Work title and Purpose updated successfully");
                        else
                            System.out.println("Something went wrong...");
                        System.out.println();
                        // break;

                    } else {
                        System.out.println("Failed to Book Appointment!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Freelancer not available on this date!!");
            }
        } else {
            System.out.println("Either Freelancer or Client doesn't exist!!!");
        }
    }

    public static boolean checkDoctorAvailability(int freelancerId, String appointmentDate, Connection connection) {
        String query = "SELECT COUNT(*) FROM appointments WHERE freelancer_id = ? AND appointment_date > ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, freelancerId);
            preparedStatement.setString(2, appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





}
