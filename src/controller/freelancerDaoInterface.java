package controller;

// import model.*;

public interface freelancerDaoInterface {


    public boolean insertfreelancer(freelancer s);
    public boolean delete(int id);
    public boolean feupdate(int id, String update,freelancer s);
    public void showAllfreelancer() ;
    public boolean freelancerById(int id);
    public boolean AppointmentById(int freelancer_id1);
    public boolean getfreelancerById(int id);
}
