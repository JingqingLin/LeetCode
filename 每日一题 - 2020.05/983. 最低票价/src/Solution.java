public class Solution {
    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        int index = 0;
        for (int i = 1; i <= lastDay; i++) {
            if (i == days[index]) {
                int day1 = i - 1;
                int day2 = Math.max(i - 7, 0);
                int day3 = Math.max(i - 30, 0);
                dp[i] = Math.min(dp[day1] + costs[0], Math.min(dp[day2] + costs[1], dp[day3] + costs[2]));
                index++;
            } else {
                // 如果这一天不是必须出行的日期，我们选择不买票
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }

    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
}
