package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnection;


public class freelancerDao implements freelancerDaoInterface{

    @Override
    public boolean insertfreelancer(freelancer s) {
        boolean flag=false;
        try{
            Connection con= DBConnection.createConnection();
            String query="insert into freelancers(name,specialization,ph_no) value(?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,s.getName());
            pst.setString(2,s.getspecialization());
            pst.setString(3,s.getph_no());
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag=false;
        try{
            Connection con=DBConnection.createConnection();
            String query="delete from freelancers where id="+id;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean feupdate(int id, String update, freelancer s) {
       
        boolean flag=false;
        try{
            
                Connection con=DBConnection.createConnection();
                String query="update freelancerS set specialization =? where id=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,id);
                ps.executeUpdate();
                flag=true;

            

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllfreelancer() {
        try{
            Connection con=DBConnection.createConnection();
            String query="select * from freelancers";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("Developer: ");
            System.out.println("+---------------+--------------------+--------------------------+-----------------------+");
            System.out.println("| Developer Id  | Name               | Specialization           | Phone Number          |");
            System.out.println("+---------------+--------------------+--------------------------+-----------------------+");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String Specialization  = rs.getString("specialization");
                String ph_no = rs.getString("ph_no");
               
                System.out.printf("| %-13s | %-18s | %-24s |%-23s|\n", id, name,Specialization,ph_no);
                System.out.println("+---------------+--------------------+--------------------------+-----------------------+");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public boolean freelancerById(int id) {
        boolean flag=false;
        try{

            Connection con=DBConnection.createConnection();
            String query="select * from freelancers where id="+id;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("Your Profile : ");
                System.out.println("Freelancer: "+rs.getInt(1)+"\n" +
                        "Name: "+rs.getString(2)+"\n" +
                        "Specialization: "+rs.getString(3)+"\n" +
                        "Phone_no: "+rs.getString(4)+"\n");
                //System.out.println("----------------------------------");
                flag=true;

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return flag;
    }


    @Override
    public boolean AppointmentById(int freelancer_id1) {
        boolean flag=false;
        try{

            Connection con=DBConnection.createConnection();
            String query="select * from appointments where freelancer_id="+freelancer_id1;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("appointments: ");
                System.out.println("+---------------------+-----------------------+-----------------------+-------------------------------------+");
                System.out.println("|  Id                 | client ID             |  Freelancer ID        | Appointment Date                    |");
                System.out.println("+---------------------+-----------------------+-----------------------+-------------------------------------+");
                while(rs.next()){
                    int id = rs.getInt("id");
                    int client_id = rs.getInt("client_id");
                    int freelancer_id = rs.getInt("freelancer_id");
                    String appointment_date = rs.getString("appointment_date");
                    System.out.printf("| %-19s | %-21s | %-21s | %-35s |\n", id, client_id, freelancer_id, appointment_date);
                    System.out.println("+---------------------+-----------------------+-----------------------+-------------------------------------+");
                    
                }
                flag=true;

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return flag;
    }


    
      public boolean getfreelancerById(int id) {
        String query = "SELECT * FROM freelancers WHERE id = ?";
        try {
            Connection con=DBConnection.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}