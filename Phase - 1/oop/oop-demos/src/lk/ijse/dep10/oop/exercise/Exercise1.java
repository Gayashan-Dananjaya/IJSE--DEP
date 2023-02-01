package lk.ijse.dep10.oop.exercise;

public class Exercise1 {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.id = 1;
        c1.name = "Kasun";
        c1.address = "Panadura";

        Customer c2 = c1;
        c2.address = "Galle";
        System.out.println(c1.id + ", " + c1.name + ", " + c1.address);

    }
}

class Customer {
    int id;
    String name;
    String address;
}
