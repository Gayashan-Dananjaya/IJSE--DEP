package miscelaneous;

public class STringConversions {
    public static void main(String[] args) {
        boolean myboolean = false;
        byte mybyte = 9;
        short myshort = 20;
        char mychar = 234;
        int myint = 34;
        long mylong = 452;
        float myFloaat = 5.425F;
        double myDouble = 275.847;

        String myString = "" + myboolean;
        System.out.println(myString);
        String myString2 = "" + myshort;
        System.out.println(myString2);
        String myString3 = "" + myint;
        System.out.println(myString3);
        String myString4 = "" + mychar;
        System.out.println(myString4);
        String myString5 = "" + mylong;
        System.out.println(myString5);
        String myString6 = "" + myFloaat;
        System.out.println(myString6);
        String myString7= "" + myDouble;
        System.out.println(myString7);
        String myString8 = "" + myboolean;
        System.out.println(myString8);

    }
}
