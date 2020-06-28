public class Solution {
    public static int maxScoreSightseeingPair(int[] A) {
        int len = A.length;
        int maxScore = 0;

        int curMaxJ = A[len - 1] - (len - 1);
        for (int j = len - 1; j > 0; j--) {
            curMaxJ = Math.max(curMaxJ, A[j] - j);
            maxScore = Math.max(maxScore, A[j - 1] + j - 1 + curMaxJ);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 8}));
    }
}
