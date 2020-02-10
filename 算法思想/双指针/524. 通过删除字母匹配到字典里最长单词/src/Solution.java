import java.util.ArrayList;
import java.util.List;

// 注意条件：字典序
public class Solution {
    public static String findLongestWord(String s, List<String> d) {
        int maxLen = 0;
        String result = "";
        for (String dicStr : d) {
            int p = 0, q = 0;
            while (q < dicStr.length() && p < s.length() && maxLen <= dicStr.length()) {
                if (dicStr.charAt(q) == s.charAt(p)) {
                    p++;
                    q++;
                } else {
                    p++;
                }
            }
            // 字典序比较
            if (q == dicStr.length() && (maxLen < q || (maxLen == q && dicStr.compareTo(result) < 0))) {
                maxLen = dicStr.length();
                result = dicStr;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        d.add("b");
        System.out.println(findLongestWord("aba", d));
    }
}
