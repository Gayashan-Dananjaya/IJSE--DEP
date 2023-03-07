package lk.ijse.dep10.serialization.model.inherit2;

import java.io.*;

public class D extends C implements Externalizable {
    public int d = 40;

    public D() {
        System.out.println("D constructor");
    }

    public D(int a, int b, int c, int d) {
        super(a, b, c);
        this.d = d;
    }


    @Override
    public String toString() {
        return "D{" +
                "d=" + d +
                ", c=" + c +
                ", b=" + b +
                ", a=" + a +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(d);
        out.write(b);
        out.write(c);
        out.write(a);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        d = in.readInt();
        b = in.readInt();
        c = in.readInt();
        a = in.readInt();

    }
}
