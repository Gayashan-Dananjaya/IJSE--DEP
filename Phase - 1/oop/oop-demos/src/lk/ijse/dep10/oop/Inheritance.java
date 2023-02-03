package lk.ijse.dep10.oop;

public class Inheritance {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("---------------------");
        Van van = new Van();
        System.out.println("---------------------");
        Van van2 = new Van();
    }
}

class Vehicle {
    static int a = 10;
    String registrationNUmber;

    static {
        System.out.println("Vehicle class is initializing");
    }

    {
        System.out.println("Vehicle object is initializing");
    }

    public Vehicle() {
        System.out.println("Vehicle constructor");
    }

    void printRegistrationNumber() {
        printInternal();
    }

    private void printInternal() {
        System.out.println(registrationNUmber);
    }

}

class Car extends Vehicle {  //car is a vehicle
    static {
        a = 15;
    }


    static {
        System.out.println("Car class is initializing");
    }

    {
        System.out.println("Car object is initializing");
    }

    public Car() {
        System.out.println("Car Constructor");
    }

}

class Van extends Vehicle {  //van is a vehicle
    static {
        System.out.println("Van class is initializing");
    }

    {
        System.out.println("Van object is initializing");
    }

    public Van() {
        System.out.println("Van constructor");
    }
}
