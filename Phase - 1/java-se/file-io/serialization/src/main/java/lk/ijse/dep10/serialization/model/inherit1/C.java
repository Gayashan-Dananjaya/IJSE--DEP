package lk.ijse.dep10.serialization.model.inherit1;

import java.io.Serializable;

public class C extends B {
    public int c = 30;

    public C() {
        System.out.println("C constructor");
    }

    public C(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String toString() {
        return "C{" +
                "c=" + c +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
