public class BetterSolution {
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        boolean isMinus = false;
        int res = 0;
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }
        if (i < chars.length && chars[i] == '-') {
            isMinus = true;
        }
        if (i < chars.length && (chars[i] == '+' || chars[i] == '-')) {
            i++;
        }
        while (i < chars.length) {
            if (chars[i] > '9' || chars[i] < '0') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7) {
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + chars[i] - '0';
            i++;
        }
        return isMinus ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(""));
    }
}
