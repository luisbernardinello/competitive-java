package leetcode.twosum;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if(complementIndex != null) {
                return new int[]{i, complementIndex};
            }

            complements.put(target - nums[i], i);
        }

        return nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        if (result1.length == 2) {
            Arrays.sort(result1);
            System.out.println(nums1[result1[0]] + " and " + nums1[result1[1]]);
        } else {
            System.out.println("solution not found");
        }
    }
}
