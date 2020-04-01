import java.util.Arrays;

public class Solution {
    public static boolean hasGroupsSizeX(int[] deck) {
        int[] times = new int[10005];
        Arrays.fill(times, 0);
        for (int i : deck) {
            times[i]++;
        }
        int base = times[deck[0]];
        for (int time : times) {
            if (time > 0 && time % base != 0 && base % time != 0) {
                int gcd = gcd(time, base);
                if (gcd >= 2) {
                    base = gcd;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (b > a) {
            return gcd(a, b % a);
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(15, 12));
    }
}
