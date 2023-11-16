package org.example.search;

@Deprecated
public class MaxValue {
    public static void main(String[] args) {
        int[] array = new int[]{12,1235,654,34,74,345,234,67654,45,34,6,345,7,234,3,23};

        int maxValue = array[0];
        int maxIndex = 0;


        for (int i = 1; i < array.length; i++) {
            if(array[i] > maxValue){
                maxValue = array[i];
                maxIndex = i;
            }
        }

        System.out.println("max index " + maxIndex);
        System.out.println("min value " + maxValue);


    }

}
