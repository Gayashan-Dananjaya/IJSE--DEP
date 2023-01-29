package miscelaneous;

public class Label {
    public static void main(String[] args) {

        first:
        {
            innerblock:
            {
                double d = 10.25;
                float f = (float) 10.25;

                System.out.println(d==f);
//                System.out.println(d===f);
            }
        }

    }
}
