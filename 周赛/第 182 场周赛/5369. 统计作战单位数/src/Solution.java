public class Solution {
    public static int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        cnt++;
                    } else if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{1,2,3,4}));
    }
}
