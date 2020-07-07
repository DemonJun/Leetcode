import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] == -nums[left] - nums[right]) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) {
                    }
                    while (left < right && nums[right] == nums[--right]) {
                    }
                } else if (nums[i] > -nums[left] - nums[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
// @lc code=end
