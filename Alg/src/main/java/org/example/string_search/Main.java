package org.example.string_search;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String text = "aabaabaababaabaababababaababaabaabababaaba";
        String sample = "aabaab";

        System.out.println(searchNative(text, sample));
    }

    static ArrayList<Integer> searchNative(String text, String sample) {
        ArrayList<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == sample.length()) {
                foundPositions.add(i);
            }
        }

        return foundPositions;
    }

    static int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + i);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();
        int[] prefixFunc = prefixFunction(sample);


        int i = 0;
        int j = 0;


        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                }else {
                    i++;
                }
            }
        }
        return found;
    }
}
