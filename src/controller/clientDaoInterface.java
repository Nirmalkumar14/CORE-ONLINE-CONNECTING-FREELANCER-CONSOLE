package controller;

// import java.sql.Connection;
// import java.util.Scanner;

// import model.clientDao;
// import model.freelancerDao;

// import model.*;

public interface clientDaoInterface {
    
    public boolean insertclient(client s);
    public boolean delete(int id);
    public boolean update(int id, String update, String spurpose, client s);
    public void showAllclient();
    public boolean showclientById(int id);
    public boolean getclientById(int id);
    // public boolean  bookAppointment(clientDao dao, freelancerDao dao1, Connection connection, Scanner scanner);
}
