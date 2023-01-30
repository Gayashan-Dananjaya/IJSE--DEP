package lk.ijse.dep10.oop;

public class InstanceCreation {
    public static void main(String[] args) {
        Customer c001 = new Customer();
        Customer c002 = new Customer();

    }
}

class Customer {
    static int id;

    static {
        System.out.println("Customer: static initializer 1");
        System.out.printf("ID : %s\n",id);
    }
    {
        System.out.println("Customer: Instance initializer");
    }
    String name;
    Customer() {
        System.out.println("Customer: constructor");
    }
    static {
        System.out.println("Customer: static initializer 2");
    }
    String address = "Panadura";

    {
        System.out.printf("Customer: Non-static initializer %s\n",address);
    }
}
