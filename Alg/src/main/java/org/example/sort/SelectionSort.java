package org.example.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{12,543,23,6,234,75,324,7456,234,7645,345,54,0};
        System.out.println(Arrays.toString(selectSort(array)));
    }


    private static int min(int start,int[] array){
        int minIndex = start;
        int minValue = array[start];

        for (int i = start + 1; i < array.length; i++) {
            if(array[i] < minValue){
                minIndex = i;
                minValue = array[i];
            }

        }

        return minIndex;
    }


    public static int[] selectSort(int[] array){

        for (int step = 0; step < array.length; step++) {
            System.out.println(Arrays.toString(array));
            int minIndex = min(step,array);
            int tmp = array[minIndex];
            array[minIndex] = array[step];
            array[step] = tmp;
        }

        return array;
    }
}
