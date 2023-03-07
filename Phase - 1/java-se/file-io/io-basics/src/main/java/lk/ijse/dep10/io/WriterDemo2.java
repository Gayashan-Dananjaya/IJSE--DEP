package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriterDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("something2.dep10");
        String someText = "I want to write this text to a file";

        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < someText.length(); i++) {
            char c = someText.charAt(i);
            byte byteOfC = (byte) c;
            fos.write(byteOfC);
        }
        fos.close();
        System.out.println("Saved ion something2.dep10 file");
    }
}
