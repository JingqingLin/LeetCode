import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartition(s, 0, partitions, tempPartition);
        return partitions;
    }

    private static void doPartition(String s, int cursorPos, List<List<String>> partitions, List<String> tempPartition) {
        if (s.length() == cursorPos) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        // 一个个试过去
        for (int i = cursorPos; i < s.length(); i++) {
            if (isPalindrome(s, cursorPos, i)) {
                tempPartition.add(s.substring(cursorPos, i + 1));
                doPartition(s, i + 1, partitions, tempPartition);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
