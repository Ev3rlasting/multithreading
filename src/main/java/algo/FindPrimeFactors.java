package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimeFactors {

    public static List<Integer> findPrimeFactors(int n) {
        if (n <= 2 && n > 0) {
            return Arrays.asList(n);
        }
        List<Integer> res = new ArrayList();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                n = n / i;
                i = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPrimeFactors(1845613249));
    }
}
