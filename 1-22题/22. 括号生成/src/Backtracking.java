import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private static List<String> list;
    private static int n;

    public static List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        Backtracking.n = n;
        generateParenthesis(0, 0, new StringBuilder());
        return list;
    }

    public static void generateParenthesis(int leftBracket, int rightBracket, StringBuilder str) {
        if (str.length() == 2 * n) {
            list.add(new String(str));
            return;
        }
        if (leftBracket < n) {
            str.append('(');
            generateParenthesis(leftBracket + 1, rightBracket, str);
            str.deleteCharAt(str.length() - 1);
        }
        if (rightBracket < leftBracket) {
            str.append(')');
            generateParenthesis(leftBracket, rightBracket + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
