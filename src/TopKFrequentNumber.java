import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumber {
//    public int[] topKFrequent(int[] nums, int k) {
//        if (nums.length <= k) {
//            return nums;
//        }
//        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k+1, Comparator.comparing(Map.Entry::getValue));
//        Map<Integer, Integer> frequency = new HashMap<>();
//        for (int num : nums) {
//            if (frequency.containsKey(num)) {
//                frequency.put(num, frequency.get(num) + 1);
//            } else {
//                frequency.put(num, 1);
//            }
//        }
//
//        int[] result = new int[k];
//
//        int count = 0;
//
//        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
//            minHeap.offer(entry);
//            if (minHeap.size() > k) {
//                result[count] = minHeap.poll().getKey();
//                count++;
//            }
//        }
//        return result;
//    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) {
            return nums;
        }
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        Map.Entry<Integer, Integer>[] numArray = (Map.Entry<Integer, Integer> [])frequency.entrySet().toArray();
        quickSelect(numArray, k, 0, frequency.size() - 1);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = numArray[numArray.length - 1 - i].getKey();
        }

        return result;
    }

    private void quickSelect(Map.Entry<Integer, Integer>[] nums, int k, int start, int end) { //O(n)
        Map.Entry<Integer, Integer> partition = nums[end];
        int pivot = start;
        for (int i=start; i<end; i++) {
            if (nums[i].getValue() < partition.getValue()) {
                swap(nums, i, pivot);
                pivot++;
            }
        }
        swap(nums, end, pivot);
        if (k == pivot) {
            return;
        } else if (k > pivot) {
            quickSelect(nums, k, pivot + 1, end);
        } else {
            quickSelect(nums, k, start, pivot - 1);
        }
    }

    private void swap(Map.Entry<Integer, Integer>[] nums, int i, int j) {
        Map.Entry<Integer, Integer> temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
