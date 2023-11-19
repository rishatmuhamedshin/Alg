package org.example.search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.SimpleFormatter;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            array[i] = i;
        }

        long startTime = System.currentTimeMillis();
        System.out.println(binarySearch(array,6));
        long totalTime = System.currentTimeMillis() - startTime;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(totalTime);
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        System.out.println(format.format(cal.getTime()));
    }

    public static int binarySearch(int[] array,int item){
        int low = 0;
        int high = array.length - 1;
        int guess = -1;
        int mid = -1;
        while (low <= high){
            System.out.println("guess = " + guess  + " mid = " + mid + " low and high " + low + " " + high);
            mid = (low + high) / 2;
            guess = array[mid - 1];
            if(guess > item) high = mid - 1;
            else low = mid + 1;
        }

        return guess;

    }
}
