package statement;

import java.util.Scanner;

public class Loop2 {
    public static void main(String[] args) {

        String[][] array = new String[3][3];
        Scanner scanner = new Scanner(System.in);
        int iteration1 = 0;
        String nic;
        String name;
        String number;
        boolean validNIC;
        boolean validName;
        boolean validNumber;

        while (iteration1 < array.length) {

            validNIC = false;
            while (!validNIC) {
                System.out.printf("%sst Customer Details\n",iteration1+1);
                System.out.print("Enter NIC Number : ");
                nic = scanner.nextLine().trim();
                int nicArrayIteration = 1;
                char[] nicArray = nic.toCharArray();
                validNIC = (nicArray.length == 4) && (nicArray[0]=='C');
                while (nicArrayIteration < 4 && validNIC && (validNIC = Character.isDigit(nicArray[nicArrayIteration++])));
                if (validNIC) array[iteration1][0] = nic;
                else System.err.println("Invalid Customer ID");
            }

            validName = false;
            while (!validName) {
                System.out.printf("%sst Customer Details\n",iteration1+1);
                System.out.print("Enter Name : ");
                name = scanner.nextLine().trim();
                int nameArrayIteration = 0;
                char[] nameArray = name.toCharArray();
                validName = (name.length() >= 3);
                while (nameArrayIteration < name.length() && validName && (validName = Character.isLetter(nameArray[nameArrayIteration]) || Character.isSpaceChar(nameArray[nameArrayIteration]))) {
                    nameArrayIteration++;
                }
                if (validName) array[iteration1][1] = name;
                else System.err.println("Enter valid name");
            }

            validNumber = false;
            while (!validNumber) {
                System.out.printf("%sst Customer Details\n",iteration1+1);
                System.out.print("Enter Mobile Number : ");
                number = scanner.nextLine().trim();
                char[] numberArray = number.toCharArray();
                int numberArrayIteration = 0;
                validNumber = number.length() == 11;
                while ( (numberArrayIteration < numberArray.length) && validNumber && (validNumber = numberArray[3] == '-') && Character.isDigit(numberArray[numberArrayIteration++]) ) {
                    if (numberArrayIteration == 3) numberArrayIteration++;
                }
                if (validNumber) array[iteration1][2]  = number;
                else System.err.println("Enter valid Mobile Number (07X-XXXXXXX)");
            }

            iteration1++;
        }

        System.out.println(array[0][0]);
        System.out.println(array[0][1]);
        System.out.println(array[0][2]);
        System.out.println(array[1][0]);
        System.out.println(array[1][1]);
        System.out.println(array[1][2]);
        System.out.println(array[2][0]);
        System.out.println(array[2][1]);
        System.out.println(array[2][2]);

        System.out.print("____________________________________________________________\nCustomer ID         Customer Name            Customer Number\n____________________________________________________________\n");
        int itr1 = 0;
        int itr2;
        while (itr1 < 3) {
            itr2 = 0;
            while (itr2 < 3) {
                System.out.printf("%s\t\t\t",array[itr1][itr2]);
                itr2++;
            }
            System.out.print("\n");
            itr1++;
            System.out.println(itr1);
        }

    }
}
