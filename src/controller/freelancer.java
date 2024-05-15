package controller;
public class freelancer {
    private int id;
    private String name;
    private String specialization;
    private String ph_no;
   

    public freelancer(){

    }

    public freelancer(String name,String specialization , String ph_no) {
        this.name = name;
       this.specialization=specialization;
        this.ph_no = ph_no;
    }

    public freelancer(int id, String name,String specialization,  String ph_no) {
        this.id = id;
        this.name = name;
        this.specialization=specialization;
        this.ph_no = ph_no;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getspecialization() {
        return specialization;
    }

    public void setspecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getph_no() {
        return ph_no;
    }

    public void setph_no(String ph_no) {
        this.ph_no = ph_no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ",name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", ph_no=" + ph_no +
                '}';
    }
}