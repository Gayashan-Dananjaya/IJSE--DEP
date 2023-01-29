package type_system;

public class Conversions {
    public static void main(String[] args) {

        /*Identity conversion*/
        boolean flag1  = true;
        boolean flag2 = flag1;

        int int1 = 10;
        int int2 = int1;

        double d1 = 10.2;
        double d2 = d1;

        /*Widening conversions*/
        byte myByte = 10;       /*Narrowing conversion*/
        short myShort = 10;     /*Narrowing conversion*/
        int myInt = 10;         /*Identity conversion*/
        long myLong = 10;       /*Widening conversion*/
        float myFloat =10;      /*Widening conversion*/
        double myDouble = 10;   /*Widening conversion*/
        myDouble = myLong;      /*Widening conversion*/
        myDouble = myInt;       /*Widening conversion*/
        myFloat = myLong;       /*Widening conversion*/
        char myChar = 'a';
        myInt = myChar;         /*Widening conversion*/
        myLong = myChar;        /*Widening conversion*/
        myDouble = myChar;      /*Widening conversion*/


        char num12 = (char) -65;
        System.out.println(num12);




    }
}
