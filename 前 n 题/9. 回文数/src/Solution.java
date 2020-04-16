public class Solution {
    public static boolean isPalindrome(int x) {
        int oriX = x;
        int rev = 0;
        int temp;
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            temp = x % 10;
            x /= 10;
            if (rev > 214748364 || rev < -214748364) {
                return false;
            }
            rev = 10 * rev + temp;
        }
        return rev == oriX;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
