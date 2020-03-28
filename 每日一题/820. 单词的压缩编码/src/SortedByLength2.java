import java.util.Arrays;
import java.util.Comparator;

public class SortedByLength2 {
    public static int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        String indexStr = "";
        for (String word : words) {
            if (!indexStr.contains(word + "#")) {
                indexStr = indexStr.concat(word + "#");
            }
        }
        System.out.println(Arrays.toString(words));
        System.out.println(indexStr);
        return indexStr.length();
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"atime", "aatime", "btime"}));
    }
}
