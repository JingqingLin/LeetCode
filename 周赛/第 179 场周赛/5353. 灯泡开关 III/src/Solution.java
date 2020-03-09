public class Solution {
    public static int numTimesAllBlue(int[] light) {
        int n = light.length;
        boolean[] states = new boolean[n];
        int cnt = 0;
        int recentAllOn = -1;
        int lastOn = -1;
        for (int value : light) {
            states[value - 1] = true;
            lastOn = Math.max(value - 1, lastOn);
            if (value - 1 <= lastOn) {
                recentAllOn++;
            }
            if (recentAllOn == lastOn) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{4,1,2,3}));
    }
}
