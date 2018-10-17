package algo;

public class Atoi {
    public static int atio(String str) {
        if (str.length() <= 0 || "".equals(str)) {
            throw new ArithmeticException();
        }
        char[] cstr = str.toCharArray();
        int i = 0;
        if (cstr[0] == '+' || cstr[0] == '-') {
            i = 1;
        }
        int result = 0;
        for (; i < str.length(); i++) {
            if (cstr[i] > '9' || cstr[i] < '0') {
                throw new ArithmeticException();
            }
            result += Math.pow(10, str.length() - i - 1) * (cstr[i] - '0');
        }
        if (cstr[0] == '-')
            return -result;
        else {
            return result;
        }
    }

    public static void main(String args[]) {
        String s = "112111111111111111";
        System.out.println(atio(s));
    }
}
