package algo;

public class Find2ndLowest {
    public static int find(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("aa");
        }
        int low, high;
        if (arr[0] <= arr[1]) {
            low = arr[0];
            high = arr[1];
        } else {
            low = arr[1];
            high = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] <= high) {
                if (arr[i] <= low) {
                    int temp = low;
                    low = arr[i];
                    high = temp;
                } else {
                    high = arr[i];
                }
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 5, 1, 4, 5, 6, 8, 6, 5, 3, 23, 1, 0, -1};
        System.out.println(find(arr));
    }
}
