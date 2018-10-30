package algo.dp;

/* 1 , 3, 5 */
public class CoinChanger {

    public static int getMinCoins(int money) {
        if (money < 0)
            throw new IllegalArgumentException();
        return function(money);
    }

    public static int function(int number) {

        if (number == 1 || number == 3 || number == 5) {
            return 1;
        }
        if (number == 2 || number == 4) {
            return 2;
        }
        int r3 = function(number - 5);
        int r2 = function(number - 3);
        int r1 = function(number - 1);
        return Math.min(r1, Math.min(r2, r3)) + 1;
    }

    public static void main(String args[]) {
        for (int i = 1; i < 100; i++)
            System.out.println(i + ": " + getMinCoins(i));
    }
}
