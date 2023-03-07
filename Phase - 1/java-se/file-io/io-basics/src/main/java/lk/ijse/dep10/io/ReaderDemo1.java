package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;

public class ReaderDemo1 {
    public static void main(String[] args) {
        File file = new File("something.dep10");

        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = fis.readAllBytes();
            fis.close();
            String s = new String(bytes);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
