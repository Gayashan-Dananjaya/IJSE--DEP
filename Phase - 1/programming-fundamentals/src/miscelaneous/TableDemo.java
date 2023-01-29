package miscelaneous;

public class TableDemo {
    public static void main(String[] args) {

        String[] columnNames = {"ID", "Name", "Contact", "Age","City"};
        String[][] data = {
                {"S001", "Kasun", "011-1234567","20","Colombo"},
                {"S002", "Nuwan Ramindu", "078-1234567","23","Sri Jayawardhanapura Kotte"},
                {"S003", "Ruwan", "033-1234567","25","Kandy"},
                {"S004", "Supun", "055-1234567","28","Matara"},
                {"S005", "Nimal", "077-1234567","30","Gampaha"},
                {"S006", "Nimal Lansa", "077-1234567","35","Jaffna"}
        };
        printTable(columnNames,data);
    }

    public static void printTable(String[] columnNames, String[][] data) {

        int numberOfColumns = columnNames.length;
        int[] maxLengthArray = findMaxLength(columnNames, data);

        // creating line
        String line = "+";
        for (int i = 0; i < numberOfColumns; i++) {
            line += "-".repeat(maxLengthArray[i]) + "+";
        }
        System.out.println(line);

        //printing column headers line
        for (int i = 0; i < numberOfColumns; i++) {
            String content = "|%-" + maxLengthArray[i] + "s";
            System.out.printf(content,columnNames[i]);
        }
        System.out.print("|\n");

        System.out.println(line);

        //printing content ines
        for (String[] datum : data) {
            for (int i = 0; i < numberOfColumns; i++) {
                String content = "|%-" + maxLengthArray[i] + "s";
                System.out.printf(content, datum[i]);
            }
            System.out.print("|\n");

        }

        System.out.println(line);
    }

    private static int[] findMaxLength(String[] columnNames, String[][] data) {
        int numberOfColumns = columnNames.length;
        int[] maxLengthArray = new int[columnNames.length];


        // for headers
        for (int i = 0; i < numberOfColumns; i++) {
            int maxLength = 0;
            if (maxLength < columnNames[i].length()+1) maxLengthArray[i] = columnNames[i].length()+1;
        }

        // for data
        for (String[] stringArray : data) {
            for (int i = 0; i < numberOfColumns; i++) {
                if (maxLengthArray[i] < stringArray[i].length()+1) maxLengthArray[i] = stringArray[i].length()+1;
            }
        }

        return maxLengthArray;
    }
}
