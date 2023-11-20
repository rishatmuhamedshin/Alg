
//Arrays.sort

package org.example.sort;


import org.example.Swap;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSort implements Swap {
    public static void main(String[] args) {
        int[] array = new int[]{123, 123, 5543, 234, 74, 234, 234, 7, 567, 6789, 67, 745, 52, 5, 346, 56, 7, 56, 345, 34, 6, 68, 56, 234, 23, 5, 7, 567, 45, 63, 53, 456, 567};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int low, int high) {

//         Базовые случаи или же точки выхода

        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        //Середина и опора
        int pivot = array[(low + high) / 2];

        // Разделение на подмассивы

        int leftMarker = low, rightMarker = high;
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    Swap.swap(array, leftMarker, rightMarker);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


        if (low < rightMarker) quickSort(array, low, rightMarker);
        if (high > leftMarker) quickSort(array, leftMarker, high);
    }


}
