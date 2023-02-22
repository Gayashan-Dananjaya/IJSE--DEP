package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        /*Making pointer using io*/
        File file = new File("/home/gayashan/Desktop/check.png");     //Making pointer using io
        if (!file.exists()) {
            System.out.println("Invalid file path");
            return;
        }

        FileInputStream fis = new FileInputStream(file); // socketing

//        byte[] bytes = new byte[fis.available()];
//        fis.read(bytes);
        byte[] bytes = fis.readAllBytes(); // reads data

        fis.close();

//        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));

    }
}
