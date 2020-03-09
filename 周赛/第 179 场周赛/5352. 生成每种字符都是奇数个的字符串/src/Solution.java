import java.util.Arrays;

public class Solution {
    public static String generateTheString(int n) {
        int len1, len2, len3;
        if (n % 2 == 0) {
            len1 = n - 1;
            len2 = 1;
            len3 = 0;
        } else {
            len1 = n;
            len2 = 0;
            len3 = 0;
        }
        char[] chars1 = new char[len1];
        char[] chars2 = new char[len2];
        char[] chars3 = new char[len3];
        Arrays.fill(chars1, 'a');
        Arrays.fill(chars2, 'b');
        Arrays.fill(chars3, 'c');
        String res = String.valueOf(chars1) + String.valueOf(chars2) + String.valueOf(chars3);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateTheString(9));
    }
}
