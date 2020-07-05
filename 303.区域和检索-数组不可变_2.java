/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    private int[] dp = null;
    private int[] data;

    // nums = [-2, 0, 3, -5, 2, -1]
    // DP状态存储定义：
    // dp[i] -> nums[0...i]元素的累积和（此时包含nums[i]点）；
    // 状态转移方程：
    // base case -> nums为空时，dp[0]数组为空；sumRang(i,j)为0；
    // dp[i] = dp[i-1] + nums[i]; -> dp[i-1] 为nums[0...i-1 范围元素的累积和；
    // sumRang(i,j) = dp[j] - dp[i] -> nums[0...j]范围元素的累积和 减 nums[0...i]范围元素的累积和；这样会减去nums[i]元素;
    // 所以换成以下算法：
    // sumRang(i,j) = dp[j] - dp[i] + nums[i];

    public NumArray(int[] nums) {
        // PS: 注意边界条件，如果传入数组为空
        if (nums.length > 0) {
            data = nums;
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
    }

    // DP解法
    public int sumRange(int i, int j) {
        if (data.length == 0) {
            return 0;
        }

        return dp[j] - dp[i] + data[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
// @lc code=end
