public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int minPriceBefore = prices[0];
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPriceBefore > prices[i]) {
                minPriceBefore = prices[i];
            }
            else {
                maxPro = Math.max(maxPro, prices[i] - minPriceBefore);
            }
        }
        return maxPro;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 4}));
    }
}
