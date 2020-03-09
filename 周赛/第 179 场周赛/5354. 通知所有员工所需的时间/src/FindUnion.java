public class FindUnion {
    /** 并查集也可以做，对于每个员工，循环找他的上级，如果比之前其他员工的时间更大，则继续往上找 */
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] time = new int[manager.length];
        for (int i = 0; i < manager.length; i++) {
            int m = i;
            int t = 0;
            while (m != -1) {
                t = t + informTime[m];
                if (t < time[m]) {
                    break;
                }
                time[m] = t;
                m = manager[m];
            }
        }
        int maxTime = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(numOfMinutes(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914}));
    }
}
