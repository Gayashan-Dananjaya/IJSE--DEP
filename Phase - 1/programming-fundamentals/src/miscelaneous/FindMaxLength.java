package miscelaneous;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] data = {"Kasun", "Ruwan Sampath", "Nuwan", "KS Ruwan Sampath"};
        findTheLongest(data);
    }

    public static void findTheLongest(String[] array) {
        int length = array[0].length();
        String name = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > length) {
                name = array[i];
                length = array[i].length();
                index = i;
            }

        }
        String output = String.format("The longest name \t: %s\nThe index \t\t\t: %s\nThe length \t\t\t: %s",name,index, length);
        System.out.println(output);
    }

}
