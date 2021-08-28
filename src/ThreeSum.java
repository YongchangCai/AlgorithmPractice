//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ThreeSum {
//    /**
//     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
//     * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//     * <p>
//     * Notice that the solution set must not contain duplicate triplets.
//     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        Map<Integer, Map<Integer, Integer>> maps = new HashMap<>();
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = -nums[i];
//            List<Integer> sum = new ArrayList<>();
//            if (findTwoSum(target, i+1, nums, sum)) {
//                sum.add(nums[i]);
//                result.add(sum);
//            }
//        }
//    }
//
//    private boolean findTwoSum (int target, int start, int[]nums, List<Integer> sum) {
//        Map<Integer, Integer> map = new HashMap<>();
//        boolean result = false;
//        for (int i=start; i < nums.length; i++) {
//            int newTarget = target - nums[i];
//            if (map.containsKey(newTarget)) {
//                sum.add(i);
//                sum.add(map.get(newTarget));
//                result = true;
//            } else {
//                map.put(newTarget, i);
//            }
//        }
//        return result;
//    }
//}
