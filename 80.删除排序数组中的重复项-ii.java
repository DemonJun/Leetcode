/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int quickIndex = 1;
        int slowIndex = 0;
        int sameNum = 1;
        for (; quickIndex < nums.length; quickIndex++) {
            if (nums[slowIndex] != nums[quickIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[quickIndex];
                sameNum = 0;
            } else if (nums[quickIndex] == nums[slowIndex] && quickIndex != slowIndex && sameNum < 2) {
                slowIndex++;
                nums[slowIndex] = nums[quickIndex];
                sameNum++;
            }
        }

        return slowIndex + 1;
    }
}
// @lc code=end
