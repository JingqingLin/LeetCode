import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i, i);
        }
        int nextIndex = 0;
        while (n > 1) {
            nextIndex = (nextIndex + m - 1) % n;
            list.remove(nextIndex);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(56795, 87778));
    }
}
