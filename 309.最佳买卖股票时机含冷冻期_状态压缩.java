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
        int noOptions = 0, buy = -prices[0], sell = 0;
        int buyPre = 0, sellPre = 0, noOptionsPre = 0;
        for (int i = 1; i < prices.length; i++) {
            // 今天不操作股票的最大收益：昨天不操作股票的收益 与 因昨天卖出股票今天不能操作股票的收益 的最大值
            sellPre = sell;
            buyPre = buy;
            noOptionsPre = noOptions;
            noOptions = Math.max(noOptionsPre, sellPre);
            // 今天买入股票的收益：昨天买入股票的收益 与 因昨天不操作股票今天可以买入股票的收益 的最大值；
            buy = Math.max(buyPre, noOptionsPre - prices[i]);
            // 今天卖出股票的收益：昨天卖出股票的收益 与 昨天买入股票今天卖出股票的收益 的最大值
            sell = Math.max(sellPre, buyPre + prices[i]);
        }

        return sell;
    }
}
// @lc code=end
