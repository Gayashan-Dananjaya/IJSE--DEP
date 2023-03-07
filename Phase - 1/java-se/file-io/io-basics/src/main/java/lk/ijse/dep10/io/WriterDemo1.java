package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileOutputStream;

public class WriterDemo1 {
    public static void main(String[] args) {
        String someText = "I want to write text into file";
        byte[] bytes = someText.getBytes();

        File file = new File("something.dep10");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
            System.out.println("Saved to writer1.dep10 file");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
