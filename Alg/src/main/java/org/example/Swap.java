package org.example;

public interface Swap {
    static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
