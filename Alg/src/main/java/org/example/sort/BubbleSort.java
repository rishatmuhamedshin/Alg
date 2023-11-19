package org.example.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 1235, 654, 34, 74, 345, 234, 67654, 45, 34, 6, 345, 7, 234, 3, 23};

        System.out.println(Arrays.toString(BubbleSorting(array)));
    }

    private static int[] BubbleSorting(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
