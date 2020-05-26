public class Solution3 {
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // 做完这个 while，slow 和 fast 相遇
        do {
            slow = nums[slow];
            // 每次走两步
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 3, 4, 2}));
    }
}
