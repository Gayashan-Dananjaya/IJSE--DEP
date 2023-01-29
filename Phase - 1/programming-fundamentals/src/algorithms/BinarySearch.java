package algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {-3, 2, 3, 5, 7, 8, 10, 10, 11};
        binarySearch(array,10);
    }

    public static void binarySearch(int[] sortedArray, int searchNumber) {
//        int[] sortedArray = BubbleSortDemo.bubbleSortMethod(inputArray);
//        int[] indexArray = BubbleSortDemo.bubbleSortIndexArray(sortedArray);
        if (searchNumber < sortedArray[0] || searchNumber > sortedArray[sortedArray.length-1]) {
            System.out.printf("The number %s is not in the range.",searchNumber);
            return;
        }

        int maxIndex = sortedArray.length-1;
        int minIndex = 0;
        int middleIndex = (maxIndex + minIndex)/ 2;

        do {
            if (sortedArray[middleIndex] == searchNumber) {
                System.out.printf("The number %s is in the index of %s",searchNumber, middleIndex);
                return;
            } else if (searchNumber == sortedArray[maxIndex]) {
                System.out.printf("The number %s is in the index of %s",searchNumber, maxIndex);
                return;
            } else if (minIndex == middleIndex) {
                System.out.printf("The number %s is not in the list",searchNumber);
                return;
            } else if (searchNumber < sortedArray[middleIndex]) {
                maxIndex = middleIndex;
                middleIndex = (minIndex + maxIndex)/ 2;
            }else {
                minIndex = middleIndex;
                middleIndex = (minIndex + maxIndex)/ 2;
            }
        } while (true);

    }
}
