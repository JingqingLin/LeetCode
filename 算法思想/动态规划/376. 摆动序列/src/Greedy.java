public class Greedy {
    public static int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        final int begin = 0;
        final int up = 1;
        final int down = -1;
        int state = begin;
        int length = 1;
        for (int i = 1; i < len; i++) {
            switch (state) {
                case begin:
                    if (nums[i - 1] < nums[i]) {
                        state = up;
                        length++;
                    } else if (nums[i - 1] > nums[i]) {
                        state = down;
                        length++;
                    }
                    break;
                case up:
                    if (nums[i - 1] > nums[i]) {
                        state = down;
                        length++;
                    }
                    break;
                case down:
                    if (nums[i - 1] < nums[i]) {
                        state = up;
                        length++;
                    }
                    break;
                default:
                    break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
