package miscelaneous;

public class StringDemo2 {
    public static void main(String[] args) {
        String star = "* ";
        System.out.println(star.repeat(5));



        String string= "      Gayashan         Dananjaya     }           ";
        System.out.println(string.stripLeading());
        System.out.println(string.stripTrailing());
        System.out.println(string.strip());


        String name = "Gayashan";
        int age = 26;
        String something = String.format("My name is %s, and my age is %s.", name, age);
        System.out.println(something);

        name = "kasun";
        age = 26;
        String contact = "011-2212345";
        something = String.format("%1$s's Details, %1$s's contact : %2$s, %1$s's age : %3$s", name, contact, age);
        System.out.println(something);

        something = String.format("%-7s", "Hello");
        System.out.println(something);
        System.out.println(something.length());

    }
}
