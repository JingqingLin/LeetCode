public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("less than 2");
        }
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        throw new IllegalArgumentException("No answer.");
    }
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{0}, 0)[0]);
    }
}
