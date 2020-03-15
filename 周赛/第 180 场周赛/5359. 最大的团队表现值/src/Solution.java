import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] efficiencyAndSpeed = new int[n][2];
        for (int i = 0; i < n; i++) {
            efficiencyAndSpeed[i][1] = efficiency[i];
            efficiencyAndSpeed[i][0] = speed[i];
        }
        Arrays.sort(efficiencyAndSpeed, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0, sum = 0;
        for(int i = 0 ; i < n ; i++){
            queue.add(efficiencyAndSpeed[i][0]);
            sum += efficiencyAndSpeed[i][0];
            if(queue.size() > k){
                sum -= queue.poll();
            }
            res = Math.max(res, sum * efficiencyAndSpeed[i][1]);
        }
        return (int)(res % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3));
    }
}
