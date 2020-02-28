public class Solution {
    public static int findRepeatNumber(int[] nums) {
        int[] map = new int[nums.length];
        for (int num : nums) {
            if (map[num] == 1) {
                return num;
            }
            map[num] = 1;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
