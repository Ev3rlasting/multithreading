package algo;

import java.util.Random;

public class SimulatePi {
    public static double getPi(int n) {
        int i = 0;

        int inner = 0, outer = 0;
        while (i++ < n) {
            Random rand = new Random();
            double x = rand.nextDouble() * 0.5;
            double y = rand.nextDouble() * 0.5;
            if (x * x + y * y <= 0.25) {
                inner++;
            } else {
                outer++;
            }
        }
        return (double)inner / (double)(inner + outer) * 4;
    }

    public static void main(String[] args) {
        double res = getPi(90000000);
        System.out.println(res);
    }
}
