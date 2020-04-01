import java.util.Arrays;
import java.util.Comparator;

public class SortedByLength {
    public static int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println(Arrays.toString(words));
        int indexLen = 0;
        for (int i = 0; i < words.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (words[j].endsWith(words[i])) {
                    break;
                }
            }
            if (j == i) {
                indexLen += words[i].length() + 1;
            }
        }
        return indexLen;
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
