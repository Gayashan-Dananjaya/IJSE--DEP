package lk.ijse.dep10.app.util;


import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArray {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        ArrayList arrayList2 = arrayList;
        arrayList.add(20);
        System.out.println(arrayList2);

        DynamicArray array1 = new DynamicArray();
        array1.add("2");
        DynamicArray array2 = array1;
        array1.add("20");
        System.out.println(array2);
    }

    private int[] array =  new int[0];

    public void add(String value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = Integer.parseInt(value);
        array = newArray;
    }

    public void add(int index, String value) {
        int j = 0;
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (i == index) newArray[j++] = Integer.parseInt(value);
            newArray[j++] = array[i];
        }
        array = newArray;
    }

    public void clear() {
        array = new int[0];
    }

    public boolean contains(String input) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == Integer.parseInt(input)) return true;
        }
        return false;
    }

    public int size() {
        return array.length;
    }

    public String get(int index) {
        return Integer.toString((array[index]));
    }

    public void remove(int index) {
        int j = 0;
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i == index) continue;
            newArray[j++] = array[i];
        }
        array = newArray;
    }

    public void set(int index, int value) {
        array[index] = value;
    }

    public int indexOf(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
//        return super.toString();
        return Arrays.toString(array);
    }
}
