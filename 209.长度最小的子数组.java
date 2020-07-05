import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = s;
            for (int j = i; j < nums.length; j++) {
                sum -= nums[j];
                if (sum <= 0) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// @lc code=end
