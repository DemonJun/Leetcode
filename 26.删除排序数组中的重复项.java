/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int quickIndex = 1;
        int slowIndex = 0;
        for (; quickIndex < nums.length; quickIndex++) {
            if (nums[slowIndex] != nums[quickIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[quickIndex];
            }
        }

        return slowIndex + 1;
    }
}
// @lc code=end
