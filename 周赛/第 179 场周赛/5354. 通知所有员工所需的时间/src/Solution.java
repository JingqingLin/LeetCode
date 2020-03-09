import java.util.ArrayList;

public class Solution {

    private static int maxTime;

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        maxTime = 0;
        ArrayList<Integer>[] son = new ArrayList[manager.length];
        for (int i = 0; i < manager.length; i++) {
            son[i] = new ArrayList();
        }
        for (int i = 0; i < manager.length; i++) {
            if (i != headID) {
                son[manager[i]].add(i);
            }
        }
        DFS(headID, informTime[headID], son, informTime);
        return maxTime;
    }

    private static void DFS(int headID, int time, ArrayList<Integer>[] sonsArray, int[] informTime) {
        ArrayList<Integer> sons = sonsArray[headID];
        for (Integer son : sons) {
            maxTime = Math.max(maxTime, time + informTime[son]);
            DFS(son, time + informTime[son], sonsArray, informTime);
        }
    }

    public static void main(String[] args) {
        System.out.println(numOfMinutes(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914}));
    }
}
