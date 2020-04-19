import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        // 遍历了多少次 s1
        int count1 = 0;
        // 遍历了多少次 s2
        int count2 = 0;
        // 当前在 s2 的位置
        int p = 0;
        Map<Integer, int[]> map = new HashMap<>();
        // 记录每一次 s1 扫描结束后当前的状态，寻找循环
        while (count1 < n1) {
            for (int i = 0; i < len1; i++) {
                if (c1[i] == c2[p]) {
                    p++;
                    // s2 扫描结束从头开始循环
                    if (p == len2) {
                        p = 0;
                        count2++;
                    }
                }
            }
            count1++;
            if (!map.containsKey(p)) {
                // 若无重复位置的 p，记录当前 count1 和 count2
                map.put(p, new int[]{count1, count2});
            } else {
                // 若这次结束后 p 的位置和以前某一次一样，则找到了循环节
                int[] last = map.get(p);
                // 一个循环节包括 circle1 个 s1 和 circle1 个 s2
                int circle1 = count1 - last[0];
                int circle2 = count2 - last[1];
                // (n1 - count1) / circle1 为剩余的 S1 字符串中还有几个循环节
                count2 += circle2 * ((n1 - count1) / circle1);
                count1 += circle1 * ((n1 - count1) / circle1);
            }
        }
        return count2 / n2;
    }

    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("abaacdbac", 5, "adcbd", 1));
        // "bacaba", 3, "abacab", 1
        // "baba", 11, "baab", 1
        // "niconiconi", 99981, "nico", 81
    }
}
