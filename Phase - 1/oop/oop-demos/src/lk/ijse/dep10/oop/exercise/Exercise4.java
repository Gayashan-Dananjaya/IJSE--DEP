package lk.ijse.dep10.oop.exercise;

import javax.swing.text.StringContent;

public class Exercise4 {
    public static void main(String[] args) {
        Teacher t001 = new Teacher("1234567890","Gayashan","1234567890");
        t001.printDetails();
    }
}

class Teacher{
    String nic;
    String name;
    String contact;

    public Teacher(String nic, String name, String contact) {
        this.nic = nic;
        this.name = name;
        this.contact = contact;
    }

    void printDetails() {
        String name = "Nuwan";
        System.out.printf("nic=%s, name=%s, contact=%s", nic, name, contact);
    }

}
