import java.util.Arrays;

public class ReverseSort {
    public static int minimumLengthEncoding(String[] words) {
        int wordsLen = words.length;
        String[] reverseWords = new String[wordsLen];
        // 字符串倒序
        for (int i = 0; i < wordsLen; i++) {
            int wordLen = words[i].length();
            char[] reverseChars = new char[wordLen];
            for (int j = 0; j < wordLen; j++) {
                reverseChars[wordLen - j - 1] = words[i].charAt(j);
            }
            reverseWords[i] = String.valueOf(reverseChars);
        }
        // 字符串排序
        Arrays.sort(reverseWords);
        System.out.println(Arrays.toString(reverseWords));
        int indexLen = 0;
        // 比较相邻字符串，若前者包含于后者则跳过
        for (int i = 0; i < wordsLen - 1; i++) {
            int len = reverseWords[i].length();
            if (reverseWords[i + 1].startsWith(reverseWords[i])) {
                continue;
            }
            indexLen += len + 1;
        }
        return indexLen + reverseWords[wordsLen - 1].length() + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"atime", "aatime", "btime"}));
    }
}
