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
        if (prices.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                continue;
            }
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
// @lc code=end
