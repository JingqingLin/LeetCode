import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = partition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        Random rand = new Random();
        int randIndex = rand.nextInt(r - l + 1) + l;
        int pivot = nums[randIndex];
        swap(nums, randIndex, l);
        while (l < r) {
            while (r > l && nums[r] > pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{2, 0, 5, 3})));
    }
}
