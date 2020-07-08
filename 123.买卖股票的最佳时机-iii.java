import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // int[i][j][k] -> i表示第i+1天；j表示第j+1次买股票；k-> 0表示持有、1表示卖出
        int k = 2;
        int[][][] dp = new int[prices.length][k][2];
        dp[0][0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] + prices[i]);
            }
        }

        return dp[prices.length - 1][k - 1][0];
    }
}
// @lc code=end
