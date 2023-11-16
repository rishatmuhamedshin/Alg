package org.example.search;

@Deprecated
public class MinValue {
    public static void main(String[] args) {
        int[] array = new int[]{12,1235,654,34,74,345,234,67654,45,34,6,345,7,234,3,23};

        int minValue = array[0];
        int minIndex = 0;


        for (int i = 1; i < array.length; i++) {
            if(array[i] < minValue){
                minValue = array[i];
                minIndex = i;
            }
        }

        System.out.println("Minimal index " + minIndex);
        System.out.println("Minimal value " + minValue);


    }


}