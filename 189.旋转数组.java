/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int index, current, tmp, switchTimes = 0;
        for (int i = 0; switchTimes < nums.length; i++) {
            index = i;
            current = nums[i];
            tmp = current;
            do {
                index = (index + k) % nums.length;
                current = nums[index];
                nums[index] = tmp;
                tmp = current;
                switchTimes++;
            } while (index != i);
        }
    }
}
// @lc code=end
