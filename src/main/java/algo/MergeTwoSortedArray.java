package algo;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static int[] merge(int[] arrA, int[] arrB) {
        if (arrA.length == 0) {
            return arrB;
        }
        if (arrB.length == 0) {
            return arrA;
        }
        int[] arrC = new int[arrA.length + arrB.length];
        int i = 0;
        int j = 0;
        int k = 0;
        boolean aEnd = false;
        boolean bEnd = false;
        while (k < arrC.length) {
            while (i < arrA.length && (bEnd || arrA[i] <= arrB[j])) {
                arrC[k] = arrA[i];
                System.out.println("arrC[" + k + "]: " + arrC[k]);
                System.out.println("i: " + i);
                i++;
                k++;
                if (i == arrA.length) {
                    aEnd = true;
                }
            }
            while (j < arrB.length && (aEnd || arrB[j] <= arrA[i])) {
                arrC[k] = arrB[j];
                System.out.println("arrC[" + k + "]: " + arrC[k]);
                System.out.println("j: " + j);
                j++;
                k++;
                if (j == arrB.length) {
                    bEnd = true;
                }
            }
        }
        return arrC;
    }

    public static int findMedian(int[] arrA, int[] arrB) {
        if (arrA.length == 0) {
            if (arrB.length == 0)
                throw new IllegalArgumentException("Cant find median with two empty arrays");
            else {
                return arrB[arrB.length >> 1];
            }
        }

        if (arrB.length == 0) {
            return arrA[arrA.length >> 1];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int result = 0;
        int end = (arrA.length + arrB.length) >> 1;
        while (k < end) {
            while (arrA[i] <= arrB[j] && k <= end) {
                result = arrA[i];
                k++;
                i++;
            }
            while (arrB[j] <= arrA[i] && k <= end) {
                result = arrB[j];
                k++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arrA = { 2, 3, 115, 3, 2, 9, 15, 6, 78, 98, 2 };
//        int[] arrB = { 1, 5, 6, 3, 25, 35, 3, 8, 2, 0, 45, 56 };
        int[] arrA = { 1,3,4};
        int[] arrB = { 1,2,3,5 };
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int[] arrC = merge(arrA, arrB);
        for (int i = 0; i < arrC.length; i++) {
            System.out.print(arrC[i] + ",");
        }
        System.out.println();
        System.out.println(findMedian(arrA, arrB));
    }
}