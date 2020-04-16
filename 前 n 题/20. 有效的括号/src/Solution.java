import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> symbol = new Stack<>();
        String in = "({[";
        String out = ")}]";
        for (int i = 0; i < s.length(); i++) {
            if (symbol.size() > s.length() / 2) {
                return false;
            }
            if (in.contains(String.valueOf(s.charAt(i)))) {
                symbol.push(s.charAt(i));
            }
            // 如果当前符号位于 out 字串，且与 in 字串位置相同，则可弹出
            else if (out.contains(String.valueOf(s.charAt(i)))) {
                if (symbol.isEmpty()) {
                    return false;
                } else if (in.indexOf(symbol.peek()) == out.indexOf(s.charAt(i))) {
                    symbol.pop();
                } else {
                    return false;
                }
            }
        }
        return symbol.isEmpty();

//        while(s.contains("()") || s.contains("[]") || s.contains("{}")) {
//            s = s.replaceAll("\\(\\)","");
//            s = s.replaceAll("\\[\\]","");
//            s = s.replaceAll("\\{\\}","");
//        }
//        return s.length() == 0;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(isValid("(((((((((((((({(((())))})))))))))"));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
