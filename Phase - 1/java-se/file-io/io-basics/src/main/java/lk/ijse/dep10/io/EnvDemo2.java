package lk.ijse.dep10.io;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.File;
import java.util.Properties;

public class EnvDemo2 {
    public static void main(String[] args) {
//        String property = System.getProperty("tmp.dir");
//        System.out.println(property);

        Properties properties = System.getProperties();
        properties.setProperty("aaa", "aaaa");
        for (Object key : properties.keySet()) {
            System.out.printf("%s \t= %s\n", key, properties.getProperty(key.toString()));
        }
        properties.remove("aaa");

        System.out.println("\n\n=================================================================\n\n");

        /*Changing JRE environment variables*/
        System.out.println(System.getProperty("os.name"));
        properties.setProperty("os.name", "Windows");
        System.out.println(System.getProperty("os.name"));

        System.out.println("\n\n=================================================================\n\n");
        System.out.println(System.getProperty("user.home"));
        File desktopDir = new File(System.getProperty("user.home"), "Desktop");
        System.out.println(desktopDir);
    }
}
