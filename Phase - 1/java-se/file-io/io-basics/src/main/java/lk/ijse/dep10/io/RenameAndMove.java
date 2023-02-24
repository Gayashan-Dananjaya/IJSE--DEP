package lk.ijse.dep10.io;

import java.io.File;

public class RenameAndMove {
    public static void main(String[] args) {

        /*Renaming a file*/
//        File oldFile = new File("/home/gayashan/Desktop/dep10.ijse");
//        File newFile = new File(oldFile.getParentFile(), "newdep10.ijse");
//        oldFile.renameTo(newFile);

        /*Move a file*/
        File srcFile = new File("/home/gayashan/Desktop/aaa");

        File desktopFolder = new File(srcFile.getParent());
        File test = new File(desktopFolder, "test/lala/hoo");

        test.mkdirs();

        File target = new File("/home/gayashan/Desktop/test/lala/hoo", srcFile.getName());
        srcFile.renameTo(target);
    }
}
