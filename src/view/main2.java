package view;
import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
import java.util.Scanner;

import controller.clientDao;
import controller.freelancerDao;
// import controller.*;
import model.*;




public class main2 {

    public main2(Connection connection, Scanner scanner) {
        // TODO Auto-generated constructor stub

    }

    public void free() {
        try (Scanner sc = new Scanner(System.in)) {
            clientDao dao = new clientDao();
            freelancerDao dao1 = new freelancerDao();
            // Connection con = DBConnection.createConnection();
            freelancerinsert in = new freelancerinsert(null, sc);
            System.out.println("Welcome to Core Online <-> application");


          
            
                while (true) {
    
                  
                    System.out.println("\n1.Add Your Account as Freelancer" +
                    "\n2.Show All Freelancer" +
                    "\n3.Get Your Freelancer profile by based on ID" +
                    "\n4.Update your Specialzation Deatails" +
                    "\n5.Get Your Appointments "+
                    "\n6.Viwe All Clients"+
                    "\n7.LogOut");
            System.out.println("Enter choice");
                    
                
                    int ch = sc.nextInt();
    
                    switch (ch) {    
                        case 1:
                          in.freelancerinsert1();
                            break;
    
                        case 2:
                            System.out.println("Show all Freelancers: ");
                            dao1.showAllfreelancer();
                            break;
    
                        case 3:
                           in.getprofilefree();
                            break;
                        case 4:
                           in.getprofilefree();
                            break;
                            case 5:
                            in.getappointment();
                            break;
                            case 6:
                            System.out.println("Show all Clients: ");
                            dao.showAllclient();
                            break;
                          case 7:
                            System.out.println("Thank You for using Core Online application!!!");
                            System.exit(0);
                          default:
                            System.out.println("Please enter valid choice..");
                    }
                    }
                
        }

    }


}