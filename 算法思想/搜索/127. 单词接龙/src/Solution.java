import java.util.*;

public class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int cnt = 1;
        Queue<String> wordQueue = new LinkedList();
        wordQueue.offer(beginWord);
        int size;
        while (!wordQueue.isEmpty()) {
            size = wordQueue.size();
            cnt++;
            while (size-- > 0) {
                String str = wordQueue.poll();
                Iterator<String> it = wordList.iterator();
                while (it.hasNext()) {
                    String word = it.next();
                    if (isOneLetterChanged(str, word)) {
                        if (endWord.equals(word)) {
                            return cnt;
                        }
                        wordQueue.offer(word);
                        it.remove();
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isOneLetterChanged(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int a = ladderLength("a", "c",
                new ArrayList<>(Arrays.asList("a", "b", "c")));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(a);
        String c = new String("abc");
        String b = new String("abc");
        System.out.println(c == b);
    }
}
