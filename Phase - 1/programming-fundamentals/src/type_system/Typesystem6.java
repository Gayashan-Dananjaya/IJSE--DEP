package type_system;

import java.io.CharArrayReader;

public class Typesystem6 {
    public static void main(String[] args) {
        String string1 = "true";
        boolean value1 = new Boolean(string1);  /*Java 8*/
        boolean value2 = Boolean.valueOf(string1);  /*Java 11*/

        String myStr = "12";

        byte myByte = new Byte(myStr);          /*Java 8*/
        byte myByte1 = Byte.valueOf(myStr);     /*Java 11*/
        System.out.println(myByte1);

        short myShort1 = new Short(myStr);
        short myShort2 = Short.valueOf(myStr);
        System.out.println(myShort2);

        int mychar1 = new Integer(myStr);
        int myChar2 = Integer.valueOf(myStr);
        System.out.println(myChar2);

//        char myChar3 = new Character(myStr);
//        char myChar4 = Character.valueOf(myStr);



    }
}
