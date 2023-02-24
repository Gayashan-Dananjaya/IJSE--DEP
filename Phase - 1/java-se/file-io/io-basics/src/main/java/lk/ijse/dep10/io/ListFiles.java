package lk.ijse.dep10.io;

import java.io.File;

public class ListFiles {

    public static void main(String[] args) {
        File desktopDir = new File("/home/gayashan/Desktop");

        System.out.println(desktopDir.isFile());
        System.out.println(desktopDir.isDirectory());

        String[] list = desktopDir.list();
        File[] files = desktopDir.listFiles();

        for (String s : list) {
            System.out.println(s);
        }
        for (File file : files) {
            System.out.println(file);
        }
    }
}
