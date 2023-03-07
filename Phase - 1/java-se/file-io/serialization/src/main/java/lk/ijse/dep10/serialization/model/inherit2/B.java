package lk.ijse.dep10.serialization.model.inherit2;

public class B extends A {
    public int b = 20;

    public B() {
        System.out.println("B constructor");
    }

    public B(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public String toString() {
        return "B{" +
                "b=" + b +
                ", a=" + a +
                '}';
    }
}
