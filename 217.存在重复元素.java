import java.lang.reflect.Array;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }


    public boolean containsDuplicateWithSort(int[] nums) {
        Arrays.sort(nums);
        int slowIndex = 0, fastIndex = slowIndex + 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] == nums[slowIndex]) {
                return true;
            } else {
                slowIndex++;
            }
            fastIndex++;
        }

        return false;
    }
}
// @lc code=end
