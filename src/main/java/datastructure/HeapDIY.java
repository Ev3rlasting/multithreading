package datastructure;

public class HeapDIY {
    private int[] arr;

    public HeapDIY(int[] arr) {
        this.arr = arr;
        buildInit(this.arr);
        //        buildInit(arr);
    }

    private void buildInit(int[] arr) {
        if (arr.length < 1) {
            throw new IllegalArgumentException("Wrong length of array");
        }
        if (arr.length == 1) {
            return;
        }
        int lastRootIdx = (arr.length >> 1) - 1;
        for (int i = lastRootIdx; i >= 0; i--) {
            maxHeapify(i);
        }

    }

    public void getRootNode() {
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    private void maxHeapify(int i) {
        int leftNodeIdx = ((i + 1) << 1) - 1;
        int rightNodeIdx = (i + 1) << 1;
        int leftNode = arr[leftNodeIdx];
        if (rightNodeIdx >= arr.length) {
            if (leftNode > arr[i]) {
                swap(leftNodeIdx, i);
            }
            return;
        }
        int rightNode = arr[rightNodeIdx];
        if (rightNode > leftNode) {
            if (rightNode > arr[i]) {
                swap(rightNodeIdx, i);
            }
        } else {
            if (leftNode > arr[i]) {
                swap(leftNodeIdx, i);
            }
        }
    }

    private void swap(int idx, int i) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
        int lastRootIdx = (arr.length >> 1) - 1;
        if (idx > lastRootIdx)
            return;
        maxHeapify(idx);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 0, 8, 1, 5, 6 };
        HeapDIY heapDIY = new HeapDIY(arr);
        System.out.println(arr);
    }
}
