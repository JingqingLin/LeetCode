public class Solution {
    public static String reverseWords(String s) {
        if (s.isEmpty()) {
            return "";
        }
        char[] chars = s.toCharArray();
        int i = s.length();
        // 删除原字串尾部空格
        while (i > 0) {
            if (chars[--i] != ' ') {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int tailPos = i + 1, headPos;
        while (i >= 0) {
            if (chars[i] == ' ') {
                headPos = i + 1;
                sb.append(s, headPos, tailPos);
                sb.append(" ");
                while (i >= 0 && chars[i] == ' ') {
                    i--;
                }
                tailPos = i + 1;
            } else {
                i--;
            }
        }
        if (chars[0] != ' ') {
            sb.append(s, 0, tailPos);
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hi, I am JingqingLin!"));
    }
}
