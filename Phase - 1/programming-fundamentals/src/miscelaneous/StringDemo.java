package miscelaneous;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter something: ");
//        String something = scanner.nextLine();
//        System.out.println(something);
//        System.out.println(something.toString());
//
//        System.out.printf("Inputted text length is %s\n", something.length());
//        System.out.printf("3rd charactare is %s\n", something.charAt(2));
//        System.out.printf("Lowercase: %s\n", something.toLowerCase());
//        System.out.printf("Uppercase: %s\n", something.toUpperCase());
//
//        something += "    " + "    ";
//
//        System.out.printf("Inputted text total length is %s\n", something.length());
//        System.out.printf("Inputted text trimmed length is %s\n", something.trim().length());

        String name = "IJSE";
        String name2 = name.toUpperCase();
        String name3 = name.toUpperCase().intern();

        System.out.println(name2=="IJSE");

        String something = "";
        System.out.println("is this blank : " + something.isBlank());
        System.out.println("is this empty : " + something.isEmpty());


        String some = "Hi! We are DEP-10";
        String extracted1 = some.substring(4);
        System.out.println(extracted1);
        String extracted2 = some.substring(0,1);
        System.out.println(extracted2);


        something = "Monday,    Tuesday,  Wdnesday    ,Thursday, Monday";

        String[] splits = something.split(",");
        System.out.println(splits.length);
        System.out.println(splits[0] = splits[0].trim());
        System.out.println(splits[1] = splits[1].trim());

        System.out.println("Is monday contains within something : " + something.toLowerCase().contains("moNDay".toLowerCase()));
        System.out.println("Tuesday starts at : " + something.indexOf("Tues"));

        String New = something.replace("day", "DAY");
        System.out.println(New);


    }
}
