package org.example.search;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int[] massiv = new int[]{1, 4, 4, 45435, 7654, 82342, 18234, 19};
        int[] massiv2 = new int[]{2, 3, 12, 4234, 432, 123, 12};
        quickSort(massiv2,0,massiv2.length - 1);
        quickSort(massiv,0,massiv.length - 1);
        System.out.println(Arrays.toString(merge(massiv2, 0, massiv, 0)));
        System.out.println(binarySearch(massiv2, 12));
        System.out.println(binarySearch(massiv2, 12, 0, massiv2.length));

    }

    public static void quickSort(int[] a,int low,int high){
        if(low >= high){
            return;
        }

        if(a.length == 0){
            return;
        }
        int pivot = a[(low + high)/2];

        int leftMarker = low, rightMarker = high;
        do {
            while(a[leftMarker] < pivot){
                leftMarker++;
            }
            while (a[rightMarker] > pivot){
                rightMarker--;
            }

            if(leftMarker <= rightMarker){
                if(leftMarker < rightMarker) {
                    int temp = a[leftMarker];
                    a[leftMarker] = a[rightMarker];
                    a[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        }while (leftMarker <= rightMarker);

        if(low < rightMarker) quickSort(a,low,rightMarker);
        if(high > leftMarker) quickSort(a,leftMarker,high);
    }
    public static int binarySearch(int[] a, int findElem, int start, int end) {
        if (end >= start) {
            int midElem = start + (end - start) / 2;
            if (a[midElem] == findElem) {
                return midElem;
            }
            if (a[midElem] > findElem) {
                return binarySearch(a, findElem, start, midElem - 1);
            } else {
                return binarySearch(a, findElem, midElem + 1, end);
            }
        }

        return -1;
    }

    public static String binarySearch(int[] a, int findElem) {
        if (a.length == 0) {
            return "false";
        }
        if (a.length < 2) {
            return "" + a[0];
        }
        int low = 0;
        int high = a.length - 1;
        int mid = -1;
        int guess = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            guess = a[mid - 1];
            if (guess > findElem) high = mid - 1;
            else low = mid + 1;
        }
        return guess + " " + mid;

    }


    public static int[] merge(int[] a, int startM1, int[] b, int startM2) {

        int index1 = startM1;
        int index2 = startM2;

        int srcEnd1 = a.length;
        int srcEnd2 = b.length;

        int iterationCol = srcEnd1 - startM1 + srcEnd2 - startM2;
        int[] desc = new int[iterationCol];
        for (int i = 0; i < iterationCol; i++) {
            if (index1 < srcEnd1 && (index2 >= srcEnd2 || a[index1] < b[index2])) {
                desc[i] = a[index1];
                index1++;
            } else {
                desc[i] = b[index2];
                index2++;
            }
        }
        return desc;

    }
}