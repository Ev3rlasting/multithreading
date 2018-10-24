package algo;

public class Fibonacci {

    public static int recursive(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        return recursive(n - 1) + recursive(n - 2);
    }

    public static int nonrecursive(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        int prev = 1;
        int result = 2;
        for (int i = 2; i < n; i++) {
            int temp = result;
            result = result + prev;
            prev = temp;
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(nonrecursive(0));
        System.out.println(nonrecursive(1));
        System.out.println(nonrecursive(2));
        System.out.println(nonrecursive(3));
        System.out.println(nonrecursive(4));
        System.out.println(nonrecursive(5));
        System.out.println(nonrecursive(4));
    }
}
