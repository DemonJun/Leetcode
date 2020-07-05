import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // DP解法
        if (prices.length < 1) {
            return 0;
        }
        // dp状态存储：
        // 1. dp[i][0] 表示 到第i天为止买入股票的最大收益（第i天买入股票的收益 与 第i-1天买入股票的收益 的最大值）
        // 2. dp[i][1] 表示 到第i天为止卖出股票的最大收益（第i天卖出股票的收益 与 第i-1天卖出股票的收益 的最大值）
        // 3. dp[i][2] 表示 到第i天为止不操作股票的最大收益（第i天不操作股票时，始终为0）
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // dp[i - 1][0] -> 到昨天为止买入股票的最大收益
            // dp[i - 1][2] - prices[i] -> 到昨天为止不操作股票的收益 - 今天买入股票的收益(因为是买入，所以收益是负的)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // dp[i - 1][1] -> 到昨天为止卖出股票的最大收益
            // dp[i - 1][0] + prices[i] -> 到昨天为止买入股票的最大收益 + 今天卖出股票的收益
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = 0;
        }

        return dp[prices.length - 1][1];
    }
}
// @lc code=end
