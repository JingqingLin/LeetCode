public class Solution {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        // 记录今天之前的最小价格
        int minBuy = prices[0];
        // 记录每天卖出时可赚得的最大利润
        int forwardMax[] = new int[len];
        // 正向遍历，prices[i] 为卖出价，minBuy 为最小买入价
        for (int i = 1; i < len; i++) {
            forwardMax[i] = Math.max(forwardMax[i - 1], prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        int maxSell = prices[len - 1];
        int max = forwardMax[len - 1];
        int backwardMax;
        // 反向遍历，prices[i] 为买入价，maxSell 为最大卖出价
        for (int j = len - 1; j > 0; j--) {
            backwardMax = maxSell - prices[j];
            max = Math.max(max, forwardMax[j] + backwardMax);
            maxSell = Math.max(maxSell, prices[j]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        // {3,3,5,0,0,3,1,4}
    }
}
