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
        // int[i][j][k] -> i表示第i天；j表示第j次交易；k-> 0表示不持有股票、1表示持有股票
        int maxTime = 2;
        int[][][] dp = new int[prices.length + 1][maxTime + 1][2];

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 1) {
                    dp[i][j][1] = -prices[0];
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }

        return dp[prices.length][maxTime][0];
    }
}
// @lc code=end
