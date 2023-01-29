package miscelaneous;

public class StringFormatting {
    public static void main(String[] args) {

        int id = 50;
//        ex: S001, S010, S120, S007, S040

        String studentID = String.format("S%03d", id);
        System.out.println(studentID);


        double price = 257253.125; // Rs 257,253.12

        String output = String.format("Rs.%,.2f",price);
        System.out.println(output);

    }
}
