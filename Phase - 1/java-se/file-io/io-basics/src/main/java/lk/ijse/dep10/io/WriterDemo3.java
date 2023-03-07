package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo3 {
    public static void main(String[] args) throws IOException {
        String someText = "I want to write this to file";
        File file = new File("something3.dep10");

        FileWriter fw = new FileWriter(file);
        fw.write(someText);
        fw.close();

        System.out.println("Saved in the something3.dep10 file");
    }
}
