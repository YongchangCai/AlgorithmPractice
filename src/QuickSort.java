public class QuickSort {


    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }


    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = sortPartition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    private int sortPartition(int[] nums, int left, int right) {
        int partition = nums[right];
        int pivot = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] < partition) {
                pivot++;
                swap(nums, i, pivot);
            }
        }
        swap(nums, pivot+1, right);
        return pivot+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
