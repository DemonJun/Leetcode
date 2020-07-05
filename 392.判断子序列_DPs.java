/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    // 双指针解法
    // 如果 s 是 t 的子序列，则循环结束时 firstIndex 指向 s的最后一位字符
    public boolean isSubsequence(String s, String t) {
        // s = "abc"
        // t = "ahbgdc"
        int firstIndex = 0;
        int lastIndex = 0;

        while (firstIndex < s.length() && lastIndex < t.length()) {
            if (s.charAt(firstIndex) == t.charAt(lastIndex)) {
                firstIndex++;
                lastIndex++;
            } else {
                lastIndex++;
            }
        }

        return firstIndex == s.length();
    }
}
// @lc code=end
