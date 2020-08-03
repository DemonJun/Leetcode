/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int max = Math.max(n, m);
        char[] result = new char[max];
        int crray = 0;

        for (int i = n - 1, j = m - 1, k = max - 1;i >= 0 || j >= 0 || k >= 0; j--, i--, k--) {
            int one = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int two = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = one + two + crray;
            result[k] = (char) (sum < 10 ? sum + '0' : sum - 10 + '0');
            crray = sum >= 10 ? 1 : 0;
        }

        return crray != 0 ? "1" + String.valueOf(result) : String.valueOf(result);
    }
}
// @lc code=end
