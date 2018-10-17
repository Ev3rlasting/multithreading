package algo;

public class QuickSort {

    public static void qsort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }

        int i = head;
        int j = tail;
        int pivotIndx = (head + tail) / 2;
        int pivotVal = arr[pivotIndx];
        while (i <= j) {
            while (arr[i] < pivotVal) {
                i++;
            }
            while (arr[j] > pivotVal) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        qsort(arr, head, j);
        qsort(arr, i, tail);

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 8, 7, 2, 6, 9, 3 };
        qsort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}