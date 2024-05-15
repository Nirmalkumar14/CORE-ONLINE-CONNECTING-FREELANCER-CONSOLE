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





public class main1 {

    public main1(Connection connection, Scanner scanner) {
        // TODO Auto-generated constructor stub

    }

    public void free() {
        try (Scanner sc = new Scanner(System.in)) {
            clientDao dao = new clientDao();
            freelancerDao dao1 = new freelancerDao();
            Connection con = DBConnection.createConnection();
            clientinsert in = new clientinsert(con, sc);
            System.out.println("Welcome to Student Management application");
            while (true) {

              
                System.out.println("\n1.Add Your Account as client" +
                        "\n2.Show All client" +
                        "\n3.Get client based on ID" +
                        "\n4.Delete client" +
                        "\n5.Update client" +
                        "\n6.Show all Freelancers"+
                        "\n7.Book Appointment"+
                        "\n8.LogOut");
                System.out.print("Enter choice:");
            
           
                
            
                int ch = sc.nextInt();

                switch (ch) {
                         
                        case 1:
                        in.insertclient1();
                        break;
                        case 2:
                        System.out.println("Show all Clients: ");
                        dao.showAllclient();
                        break;
                    case 3:
                          in.getprofileclient();

                        break;
                    case 4:
                        in.Deleteclient();
                        break;
                    case 5:
                         in.updateclient();
                        break;

                    case 6:
                    System.out.println("Show all Freelancers: ");
                            dao1.showAllfreelancer();
                            break;
                    case 7:
                     in.bookAppointment(dao, dao1, con, sc);
                        break;

                    case 8:
                        System.out.println("Thank You for using Core Online application!!!");
                        System.exit(0);
                    default:
                        System.out.println("Please enter valid choice..");
                }
                }
            }       
        }
}