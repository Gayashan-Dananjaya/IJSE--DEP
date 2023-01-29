package type_system;

public class Typesystem5 {
    public static void main(String[] args) {
        int myInt = 143;

        String myString0 = myInt + "";                      /*Most common methods*/
        System.out.println(myString0);

        String myString = new Integer(myInt).toString();    /*Java SE8*/
        System.out.println(myString);

        String myString2 = Integer.toString(myInt);         /*Java SE9 upwards*/
        System.out.println(myString2);



    }
}
