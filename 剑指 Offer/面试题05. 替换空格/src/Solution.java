public class Solution {
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder newStr = new StringBuilder();
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                newStr.append(chars, pre + 1, i - pre - 1);
                newStr.append("%20");
                pre = i;
            }
        }
        newStr.append(chars, pre + 1, s.length() - pre - 1);
        return String.valueOf(newStr);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("   "));
    }
}
