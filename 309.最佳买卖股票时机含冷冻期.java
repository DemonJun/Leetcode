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
        // dp[i][j] -> i 表示第 i 天；j -> 0:不操作股票；1:买入股票；2:卖出股票；
        int[][] dp = new int[prices.length][3];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 今天不操作股票的最大收益：昨天不操作股票的收益 与 因昨天卖出股票今天不能操作股票的收益 的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 今天买入股票的收益：昨天买入股票的收益 与 因昨天不操作股票今天可以买入股票的收益 的最大值；
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 今天卖出股票的收益：昨天卖出股票的收益 与 昨天买入股票今天卖出股票的收益 的最大值
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        }

        return dp[prices.length - 1][2];
    }
}
// @lc code=end
