public class Solution {

    /**
     * @param target
     * @param mountainArr 力扣中的此参数为 MountainArray 接口，为方便实现改成 int[] 了
     * @return
     */
    public static int findInMountainArray(int target, int[] mountainArr) {
        int l = 0, r = mountainArr.length - 1;
        // 找峰值
        int maxIndex = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            int temp = mountainArr[m];
            int left = mountainArr[m - 1];
            int right = mountainArr[m + 1];
            if (temp > left && temp > right) {
                maxIndex = m;
                break;
            } else if (temp > left) {
                l = m + 1;
            } else if (temp > right) {
                r = m;
            }
        }
        System.out.println("maxIndex: " + maxIndex);
        l = 0;
        r = maxIndex;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (mountainArr[m] == target) {
                return m;
            } else if (mountainArr[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l = maxIndex;
        r = mountainArr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (mountainArr[m] == target) {
                return m;
            } else if (mountainArr[m] < target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (mountainArr[l] == target) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findInMountainArray(5, new int[]{1,5,2}));
    }
}
