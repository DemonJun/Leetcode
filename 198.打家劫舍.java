/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    // 滚动数组解法，只用了3个变量，所以空间复杂度为O(1)
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int i_2 = nums[0];
        int i_1 = Math.max(nums[0], nums[1]);
        int today = i_1;

        for (int i = 2; i < nums.length; i++) {
            today = Math.max(i_1, i_2 + nums[i]);
            i_2 = i_1;
            i_1 = today;
        }

        return today;
    }

    // DP解法，空间复杂度为O(n)
    public int rob_dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // DP状态存储：
        // dp[i] -> 第i间房屋偷窃或不偷窃的收益最大值
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        int[] dp = new int[nums.length];
        // 只有一间房屋，偷它收益最大，即收益最大值为该房屋的偷窃收益最大值
        if (nums.length >= 1) {
            dp[0] = nums[0];
        }
        // 如果只有两间房屋，那间收益最大，就偷哪间，即收益最大值为两间房屋的偷窃收益最大值
        if (nums.length >= 2) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
// @lc code=end
