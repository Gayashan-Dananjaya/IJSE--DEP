package statement;

public class BreakStatement3 {
    public static void main(String[] args) {
        first:
        {
            System.out.println("First started");
            second:
            {
                System.out.println("Second started");
                third:
                {
                    System.out.println("Third started");
                    fourth:
                    {
                        System.out.println("Fourth started");
                        if (true) break third;
                        System.out.println("Fourth ended");

                    }
                    System.out.println("Third ended");
                }
                System.out.println("Second ended");
            }
            System.out.println("First ended");
        }

    }
}
