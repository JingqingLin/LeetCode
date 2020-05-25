public class BetterSolution {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }

        // 用来统计 t 中每个字符出现次数
        int[] needs = new int[128];
        // 用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        // 目前有多少个字符
        int count = 0;
        // 用来记录最短需要多少个字符
        int minLength = Integer.MAX_VALUE, minStart = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;

            // 如果 t 中 ch 的个数大于等于窗口中 ch 的个数，则 count 增加
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            // 移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("AAACB", "AB"));
    }
}
