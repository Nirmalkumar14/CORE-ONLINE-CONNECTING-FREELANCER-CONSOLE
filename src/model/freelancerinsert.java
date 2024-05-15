package model;

import controller.clientDao;
import controller.freelancer;
import controller.freelancerDao;

import java.sql.Connection;
import java.util.*;

public class freelancerinsert {



     public freelancerinsert(Connection connection, Scanner scanner) {
        // TODO Auto-generated constructor stub

    }
    clientDao dao = new clientDao();
    freelancerDao dao1 = new freelancerDao();
    Scanner sc = new Scanner(System.in);
    DBConnection con = new DBConnection();
    public void freelancerinsert1() {
        System.out.println("Add Your Account as freelancer");
        System.out.println("Enter freelancer name:");
        String name1 = sc.next();
        System.out.println("Enter Your specialization:");
        String specialization = sc.next();
        System.out.println("Enter Your Phone num:");
        String ph_no1 = sc.next();
        freelancer stt = new freelancer(name1, specialization, ph_no1);
        boolean ans1 = dao1.insertfreelancer(stt);
        if (ans1)
            System.out.println("Record inserted Successfully!!!");
        else
            System.out.println("something went wrong, please try again");

    }

    public void getprofilefree() {
        System.out.println("Get Freelancer based on Id");
        System.out.println("enter Your Freelancer_Id");
        int roll1 = sc.nextInt();
        boolean f1 = dao1.freelancerById(roll1);
        if (!f1)
            System.out.println("Freelancer with this id is not available in our system");

    }

    public void updatefreelancer() {
        System.out.println("Update the Freelancer");

        System.out.println("enter id number");
        int rnum11 = sc.nextInt();
        System.out.println("Enter new Specialization");
        String sname1 = sc.next();
        freelancer std1 = new freelancer();
        std1.setName(sname1);
        boolean flag1 = dao1.feupdate(rnum11, sname1, std1);
        if (flag1)
            System.out.println("Specialization updated successfully");
        else
            System.out.println("Something went wrong...");
    }

    public void getappointment() {
        System.out.println("Get Appointments based on Id");
        System.out.println("enter Your Freelancer_Id");
        int roll = sc.nextInt();
        boolean f = dao1.AppointmentById(roll);
        if (!f)
            System.out.println("Freelancer AppointMents with this id is not available in our system");
    }





}