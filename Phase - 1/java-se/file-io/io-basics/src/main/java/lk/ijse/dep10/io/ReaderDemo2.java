package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReaderDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("something2.dep10");
        FileInputStream fis = new FileInputStream(file);
        String someText = "";

        while (true) {
            int readByte = fis.read();
            if (readByte == -1) break;
            char c = (char) readByte;
            someText += c;
        }

        fis.close();
        System.out.println(someText);
    }
}
