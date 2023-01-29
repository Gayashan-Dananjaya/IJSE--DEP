package algorithms;

public class BinarySearchWithSorting {
    public static void main(String[] args) {
        int[] array = {-3, 20, 130, -5, 7, 8, 10, 10, 11};
        binarySearch(array,11);
    }

    public static void binarySearch(int[] unsortedArray, int searchNumber) {
        int[] indexArray = BubbleSortDemo.bubbleSortIndexArray(unsortedArray);
        int[] sortedArray = BubbleSortDemo.bubbleSortMethod(unsortedArray);
        if (searchNumber < sortedArray[0] || searchNumber > sortedArray[sortedArray.length-1]) {
            System.out.printf("The number %s is not in the range.",searchNumber);
            return;
        }

        int maxIndex = sortedArray.length-1;
        int minIndex = 0;
        int middleIndex = (maxIndex + minIndex)/ 2;

        do {
            if (sortedArray[middleIndex] == searchNumber) {
                System.out.printf("The number %s is in the index of %s",searchNumber, indexArray[middleIndex]);
                return;
            } else if (searchNumber == sortedArray[maxIndex]) {
                System.out.printf("The number %s is in the index of %s",searchNumber, indexArray[maxIndex]);
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
