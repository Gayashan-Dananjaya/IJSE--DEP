package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/gayashan/Desktop/Cadaver [2022] 1080p 10bit DS4K WEB-DL x265.mkv");

        FileInputStream fis = new FileInputStream(file);

        while (true) {
            byte[] buffer = new byte[1024 * 1024 * 10]; // 1MB * 10
            int read = fis.read(buffer);

            if (read == -1) {
                break;
            }
        }
        fis.close();
    }
}
