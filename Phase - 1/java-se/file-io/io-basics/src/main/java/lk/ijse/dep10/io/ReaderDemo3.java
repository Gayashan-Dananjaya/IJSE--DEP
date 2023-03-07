package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("something3.dep10");
        char[] buffer = new char[100];

        FileReader fr = new FileReader(file);
        int read = fr.read(buffer);
        fr.close();

        String someText = new String(buffer, 0, read);
        System.out.println(someText);
    }
}
