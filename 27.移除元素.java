/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
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
