package org.example.sort;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = new int[]{123,123,5543,234,74,234,234,7,567,6789,67,745,52,5,346,56,7,56,345,34,6,68,56,234,23,5,7,567,45,63,53,456,567};

    }

    private void swap(int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
