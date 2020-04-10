import java.util.LinkedList;
import java.util.List;

public class Backtracking {
    private static List<String> list;
    private static int n;

    public static List<String> generateParenthesis(int n) {
        list = new LinkedList<>();
        Backtracking.n = n;
        generate(new StringBuilder(), 0, 0, 2 * n);
        return list;
    }

    private static void generate(StringBuilder sb, int left, int right, int residue) {
        if (residue == 0) {
            list.add(String.valueOf(sb));
            return;
        }
        if (left == right) {
            sb.append('(');
            generate(sb, left + 1, right, residue - 1);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left > right && left < n) {
            sb.append('(');
            generate(sb, left + 1, right, residue - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            generate(sb, left, right + 1, residue - 1);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left == n) {
            sb.append(')');
            generate(sb, left, right + 1, residue - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
