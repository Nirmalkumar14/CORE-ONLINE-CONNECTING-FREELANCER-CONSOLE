package controller;

public class client {
    private int id;
    private String name;
    private String work;
    private String purpose;
    private String ph_no;

    public client(){

    }

    public client(String name, String work, String purpose, String ph_no) {
        this.name = name;
        this.work = work;
        this.purpose = purpose;
        this.ph_no = ph_no;
    }

    public client(int id, String name, String work, String purpose, String ph_no) {
        this.id = id;
        this.name = name;
        this.work = work;
        this.purpose = purpose;
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

    public String getwork() {
        return work;
    }

    public void setwork(String work) {
        this.work = work;
    }

    public String getpurpose() {
        return purpose;
    }

    public void setpurpose(String purpose) {
        this.purpose = purpose;
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
                ", work='" + work + '\'' +
                ", purpose='" + purpose + '\'' +
                ", ph_no=" + ph_no +
                '}';
    }
}