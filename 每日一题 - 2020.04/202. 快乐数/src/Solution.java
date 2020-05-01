import java.util.HashSet;

public class Solution {
    public static boolean isHappy(int n) {
        HashSet<Integer> num = new HashSet<>();
        num.add(n);
        while (n != 1) {
            int temp = n;
            n = 0;
            while (temp != 0) {
                n += (temp % 10) * (temp % 10);
                temp /= 10;
            }
            if (num.contains(n)) {
                return false;
            } else {
                num.add(n);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(0));
    }
}
