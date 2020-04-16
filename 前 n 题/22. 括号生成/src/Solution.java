import java.util.*;

public class Solution {
    public static List<String> generateParenthesis(int n) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("()");
        if (n == 1) {
            List<String> result = new ArrayList<>(stringSet);
            return result;
        } else {
            List<String> result = new ArrayList<>(insertParenthesis(stringSet, n));
            return result;
        }
    }

    private static Set<String> insertParenthesis(Set<String> stringSet, int n) {
        if (n == 1) {
            return stringSet;
        } else {
            Set<String> newStringSet = new HashSet<>();
            // Set 中 String 的每个位置都插入 "()"
            for (String str : stringSet) {
                for (int i = str.length() - 1; i >= 0; i--) {
                    StringBuilder tempStr = new StringBuilder();
                    tempStr.append(str);
                    tempStr.insert(i, "()");
                    newStringSet.add(String.valueOf(tempStr));
                }
            }
            return insertParenthesis(newStringSet, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
