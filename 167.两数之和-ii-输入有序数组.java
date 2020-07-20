/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int smallIndex = 0;
        int bigIndex = numbers.length - 1;
        while (smallIndex < bigIndex) {
            if (numbers[smallIndex] > target - numbers[bigIndex]) {
                bigIndex--;
            } else if (numbers[smallIndex] < target - numbers[bigIndex]) {
                smallIndex++;
            } else {
                return new int[] { smallIndex + 1, bigIndex + 1 };
            }
        }

        return new int[] {};
    }
}
// @lc code=end
