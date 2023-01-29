package statement;

public class Assertion {
    public static void main(String[] args) {

        int x = 10;
        int result = x + 15;
        assert result == 20;    /*This is an assertion statement. This option is disabled by default. This is used in testings*/
        System.out.println("This line has printed...");
    }
}
