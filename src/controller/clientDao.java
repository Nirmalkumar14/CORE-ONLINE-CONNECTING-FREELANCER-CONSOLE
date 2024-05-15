package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import java.util.Scanner;

import model.DBConnection;

// import view.*;
public class clientDao implements clientDaoInterface
{

   

    // @Override
    public boolean insertclient(client s) {
        boolean flag=false;
        try{
            Connection con= DBConnection.createConnection();
            String query="insert into client(name,work,purpose,ph_no) value(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,s.getName());
            pst.setString(2,s.getwork());
            pst.setString(3,s.getpurpose());
            pst.setString(4,s.getph_no());
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
            String query="delete from client where id="+id;
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
    public boolean update(int id, String update, String update1, client s) {
        
        boolean flag=false;
        try{
            
                Connection con=DBConnection.createConnection();
                String query="update client set work=?,purpose=? where id=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setString(2,update1);
                ps.setInt(3,id);
                ps.executeUpdate();
                flag=true;

            

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllclient() {
        try{
            Connection con=DBConnection.createConnection();
            String query="select * from client";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("Clients: ");
            System.out.println("+---------------------+-----------------------+-----------------------+-----------------------------------------------+-------------------+");
            System.out.println("| client Id           | Name                  | work                  | purpose                                       |Phone Number       |");
            System.out.println("+---------------------+-----------------------+-----------------------+-----------------------------------------------+-------------------+");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String work = rs.getString("work");
                String purpose = rs.getString("purpose");
                String ph_no = rs.getString("ph_no");
                System.out.printf("| %-19s | %-21s | %-21s | %-45s |%-19s|\n", id, name, work, purpose,ph_no);
                System.out.println(
                    "+---------------------+-----------------------+-----------------------+-----------------------------------------------+-------------------+");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public boolean showclientById(int id) {
        boolean flag=false;
        try{

            Connection con=DBConnection.createConnection();
            String query="select * from client where id="+id;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("Your Profile : ");
                System.out.println("Client: "+rs.getInt(1)+"\n" +
                        "Name: "+rs.getString(2)+"\n" +
                        "Work: "+rs.getString(3)+"\n" +
                        "Purpose: "+rs.getString(4)+"\n" +
                        "Phone_no: "+rs.getString(5));
                //System.out.println("----------------------------------");
                flag=true;

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return flag;
    }

   public boolean getclientById(int id) {
        String query = "SELECT * FROM client WHERE id = ?";
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

// @Override
// public boolean bookAppointment(clientDao dao, freelancerDao dao1, Connection connection, Scanner scanner) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'bookAppointment'");
// }
 
}
