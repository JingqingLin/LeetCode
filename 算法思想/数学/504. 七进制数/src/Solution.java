public class Solution {
    /**
     * 0 1 2 3 4 5 6
     */
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder base7 = new StringBuilder();
        boolean isMinus = num < 0;
        if (isMinus) {
            num = -num;
        }
        int div = 7;
        while (num > 0) {
            base7.insert(0, num % div);
            num /= 7;
        }
        if (isMinus) {
            base7.insert(0, '-');
        }
        return String.valueOf(base7);
        // Java 中 static String toString(int num, int radix) 可以将一个整数转换为 radix 进制表示的字符串
        // return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
}
