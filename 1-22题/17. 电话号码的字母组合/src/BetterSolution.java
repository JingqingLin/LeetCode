import java.util.ArrayList;
import java.util.List;

public class BetterSolution {
    private static final String[] KEYS =
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        combine(combinations, new StringBuilder(), digits);
        return combinations;
    }

    private static void combine(List<String> combinations, StringBuilder prefix, String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(String.valueOf(prefix));
            return;
        }
        int currentDigit = digits.charAt(prefix.length()) - '0';
        for (char c : KEYS[currentDigit].toCharArray()) {
            prefix.append(c);
            combine(combinations, prefix, digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
