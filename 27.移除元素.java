/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素 
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }

        int slowIndex = 0;
        int fastIndex = 0;

        for (; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        return slowIndex;
    }
}
// @lc code=end
