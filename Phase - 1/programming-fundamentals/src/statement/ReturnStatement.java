package statement;

public class ReturnStatement {
    public static void main(String[] args) {
        System.out.println("1");
        System.out.println(add(1,2));
        if (true) return;
        System.out.println("2");
    }

    public static int add(int num1, int num2){
        num1 += num2;
        return num1;
    }

}
