package org.example.merge;

import java.util.Arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6,8,9,10};
        int[] b = new int[]{2,4,6,7,8,30,40};


        System.out.println(Arrays.toString(megre(a,0,b,0)));

        int array[] = new int[]{123, 123, 5543, 234, 3,1,2,74, 234, 234, 7, 567, 6789, 67, 745, 52, 5, 346, 56, 7, 56, 345, 34, 6, 68, 56, 234, 23, 5, 7, 567, 45, 63, 53, 456, 567};
        System.out.println(Arrays.toString(sortArray(array)));

    }

    public static int[] sortArray(int[] arrayA){
        if(arrayA == null){
            return null;
        }
        if(arrayA.length < 2){
            return arrayA;
        }

        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA,0,arrayB,0,arrayA.length/2);



        int[] arrayC = new int[arrayA.length-arrayA.length/2];
        System.arraycopy(arrayA,arrayA.length/2,arrayC,0,arrayA.length-arrayA.length/2);

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return megre(arrayB,0,arrayC,0);

    }

    public static int[] megre(int[] src1, int startElem1, int[] src2, int startElem2) {

        int index1 = startElem1;
        int index2 = startElem2;

        int srcEnd1 = src1.length;
        int srcEnd2 = src2.length;

        int iterationCount = srcEnd1 - startElem1 + srcEnd2 - startElem2;

        int[] desc = new int[iterationCount];
        for (int i = 0; i < iterationCount; i++) {
            if (index1 < srcEnd1 && (index2 >= srcEnd2 || src1[index1] < src2[index2])) {

                desc[i] = src1[index1];
                index1++;
            }else{
                desc[i]= src2[index2];
                index2++;
            }
        }
        return desc;


    }
}
