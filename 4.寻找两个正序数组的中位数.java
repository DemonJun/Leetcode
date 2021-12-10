import java.util.List;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            int n;
            if (nums1[i] <= nums2[j]) {
                n = nums1[i];
                i++;
            } else {
                n = nums2[j];
                j++;
            }

            if (n == 0 && k == 0) {
                k++;
            } else if (result[k] != n) {
                result[k] = n;
                k++;
            }
        }

        if (i == nums1.length) {
            for (; j < nums2.length; j++) {
                if (result[k] != nums2[j]) {
                    result[k] = nums2[j];
                    k++;
                }
            }
        }
        if (j == nums2.length) {
            for (; i < nums1.length; i++) {
                if (result[k] != nums1[i]) {
                    result[k] = nums1[i];
                    k++;
                }
            }
        }

        int size = result.length;
        if (size % 2 != 1) {
            return (result[size / 2 - 1] + result[size / 2] + 0.0) / 2;
        } else {
            return result[(size - 1) / 2];
        }
    }
}
// @lc code=end
