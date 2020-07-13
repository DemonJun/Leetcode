/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // dp[i][j] -> i 表示第 i 天；j -> 0:不持有股票；1:持有股票；
        int[][] dp = new int[prices.length][3];
        dp[0][1] = -prices[0];
        int dp_i2_0 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp_i2_0 - prices[i]);
            dp_i2_0 = dp[i][0];
        }


        return dp[prices.length - 1][0];
    }
}
// @lc code=end
