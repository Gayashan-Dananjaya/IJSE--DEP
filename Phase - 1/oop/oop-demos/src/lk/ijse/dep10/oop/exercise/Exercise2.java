package lk.ijse.dep10.oop.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        Student s001;
        System.out.println(s001 = new Student(1, "Kasun", "077-1234567"));
        Student s002 = new Student();
        s002.name = s001.name;
        System.out.println(s002);
    }
}

class Student {
    int id;
    String name;
    String contactNumber;

    public Student() {

    }

    public Student(int sId, String sName, String sContact) {
        id = sId;
        name = sName;
        contactNumber = sContact;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
