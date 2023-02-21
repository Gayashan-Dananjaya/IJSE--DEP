package lk.ijse.dep10.app.model;

import lk.ijse.dep10.app.util.Gender;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String id;
    private String name;
    private Gender gender;
    private ArrayList<String> contact;
    private String degree;
    private ArrayList<String> modules;
    private boolean partTime;

    public Student(String id, String name, Gender gender, ArrayList<String> contact, String degree, ArrayList<String> modules, boolean partTime) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.degree = degree;
        this.modules = modules;
        this.partTime = partTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<String> getContact() {
        return contact;
    }

    public void setContact(ArrayList<String> contact) {
        this.contact = contact;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ArrayList<String> getModules() {
        return modules;
    }

    public void setModules(ArrayList<String> modules) {
        this.modules = modules;
    }

    public boolean isPartTime() {
        return partTime;
    }

//    public String getPartTime() {
//        return "Part Time : " + partTime;
//    }

    public void setPartTime(boolean partTime) {
        this.partTime = partTime;
    }
}
