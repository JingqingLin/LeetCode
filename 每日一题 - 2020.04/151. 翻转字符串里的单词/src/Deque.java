import java.util.LinkedList;

public class Deque {
    public static String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        LinkedList<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() != 0) {
                deque.addFirst(String.valueOf(sb));
                sb.setLength(0);
            }
            left++;
        }

        // 最后没有空格，所以要把最后一个 sb 加上
        deque.addFirst(String.valueOf(sb));
        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hi, I am JingqingLin!"));
    }
}
