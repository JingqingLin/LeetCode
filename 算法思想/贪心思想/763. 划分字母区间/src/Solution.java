import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> partitionList = new ArrayList<>();
        int fromIndex = -1;
        int lastIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            lastIndex = Math.max(S.lastIndexOf(S.charAt(i)), lastIndex);
            if (lastIndex == i) {
                partitionList.add(lastIndex - fromIndex);
                fromIndex = lastIndex;
            }
            // 提前停止
            else if (lastIndex == S.length() - 1) {
                partitionList.add(lastIndex - fromIndex);
                break;
            }
        }
        return partitionList;
    }
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacacdefegdehihklij"));
    }
}
