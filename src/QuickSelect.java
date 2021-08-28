import java.util.LinkedList;
import java.util.List;

/**
 * Quick select: find kth smallest number in array of int
 */
public class QuickSelect {

    public int findKSmallest(int n, int[] nums) {
        if (n > nums.length) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.
        return quickSelect(nums, 0, nums.length-1, n);
    }

    private int quickSelect(int[] nums, int left, int right, int target) {
        int result = sortPartition(nums, left, right);
        if (target == result) {
            return nums[target];
        }
        if (target < result) {
            return quickSelect(nums, left, result - 1, target);
        }
        if (target > result) {
            return quickSelect(nums, result + 1, right, target);
        }
        return -1;
    }

    private int sortPartition(int[] nums, int left, int right) {
        int partition = nums[right];
        int pivit = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] < partition) {
                pivit++;
                swap(nums, pivit, i);
            }
        }
        swap(nums, pivit + 1, right);
        return pivit + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
