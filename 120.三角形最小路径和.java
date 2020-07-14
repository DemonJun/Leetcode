import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();
        dp.addAll(triangle.get(triangle.size() - 1));

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j));
            }
        }

        return dp.get(0);
    }
}
// @lc code=end
