/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    private int[] dp;

    // DP解法
    // nums = [-2, 0, 3, -5, 2, -1]
    // DP状态存储定义：
    // dp[i] -> 索引 0 - i-1 范围的元素之和（此时不包含nums[i]点）；
    // 状态转移方程：
    // dp[i+1] = dp[i] + nums[i]; -> dp[i] 为索引 0 - i-1 范围的元素之和；
    // sumRang(i,j) = dp[j+1] - dp[i] -> 索引 0 - j 范围的元素之和 减 索引 0 - i-1
    // 范围的元素之和，此时正好未减去nums[i]元素;
    // 例如：j = 2；i = 0；
    // dp = [0, -2, -2, 1, -4, -2, -3]
    // dp[j] = -2 -> -2+0 -> 不包含nums[2]:3
    // dp[i] = 0 -> 0 -> 不包含nums[0]:-2
    // dp[j+1] = 1 -> -2+0+3 -> 包含nums[2]:3
    // sumRang(0,2) = dp[2+1] - dp[0] = 1-0 = 1
    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
// @lc code=end
