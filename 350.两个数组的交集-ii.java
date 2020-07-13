import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int firstIndex = 0, secondIndex = 0;
        int[] result = new int[nums1.length];
        int resultIndex = 0;
        while (firstIndex < nums1.length && secondIndex < nums2.length) {
            if (nums1[firstIndex] == nums2[secondIndex]) {
                result[resultIndex] = nums1[firstIndex];
                firstIndex++;
                secondIndex++;
                resultIndex++;
            } else if (nums1[firstIndex] > nums2[secondIndex]) {
                secondIndex++;
            } else {
                firstIndex++;
            }
        }

        return Arrays.copyOfRange(result, 0, resultIndex);
    }
}
// @lc code=end
