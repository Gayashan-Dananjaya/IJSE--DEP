import java.util.Optional;

public class NullObjectDP {
    public static void main(String[] args) {
        System.out.println(extract1("IJSE",1,3).toUpperCase());
        System.out.println(extract1("Something",-2,3).toUpperCase());
        System.out.println(extract1("Here is some text",5,3).toUpperCase());
        System.out.println(extract1("Here is some text",3,7).toUpperCase());
    }

    public static String extract1(String input, int start, int end) {
        if (start<0 || end>input.length()) return null;
        String extractedText = input.substring(start, end);
        return extractedText;
    }

//    public static Optional<String> extract2(String input, int start, int end) {
//        if ()
//    }
}
