public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxPro = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                maxPro += prices[i + 1] - prices[i];
            }
        }
        return maxPro;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 4}));
    }
}
