package org.example.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = new int[]{123, 123, 5543, 234, 74, 234, 234, 7, 567, 6789, 67, 745, 52, 5, 346, 56, 7, 56, 345, 34, 6, 68, 56, 234, 23, 5, 7, 567, 45, 63, 53, 456, 567};

        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--){
                if(value < array[i]){
                    array[i + 1] = array[i];
                }else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        System.out.println(Arrays.toString(array));
    }

}
