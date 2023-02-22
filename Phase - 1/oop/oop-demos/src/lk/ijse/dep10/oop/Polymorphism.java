package lk.ijse.dep10.oop;

public class Polymorphism {
    public static void main(String[] args) {
        Prius prius = new Prius();

        Car2 myCar = prius;
        System.out.println(myCar);
        System.out.println(myCar == prius);
    }
}

class Vehicle2 {
    public void horn(){}
    public void accelerator(){}
    public void pushBreak(){}

}

class Car2 extends Vehicle2 {
    public void advancedBreakingSystems(){
        System.out.println("Car : Advanced Breaking System");
    }
}

class Prius extends Car2 {
    public void hybrid(){}
    public void advancedBreakingSystems(){
        System.out.println("Prius : Advanced Breaking System");
    }
}

class Bugatti extends Car2 {
    public void turboAcceleration(){}
    public void advancedBreakingSystems(){
        System.out.println("Bugatti : Advanced Breaking System");
    }
}


