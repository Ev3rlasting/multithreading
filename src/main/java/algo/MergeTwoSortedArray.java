package algo;

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

    public static void main(String[] args) {
        int[] arrA = {};
        int[] arrB = { 1 };
        int[] arrC = merge(arrA, arrB);
        System.out.println(arrC);
    }
}
