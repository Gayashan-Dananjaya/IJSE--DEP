package lk.ijse.dep10.app.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String firstName;
    private String lastname;
    private String address;
    private Gender gender;
    private LocalDate dob;

    public Student(int id, String firstName, String lastname, String address, Gender gender, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
