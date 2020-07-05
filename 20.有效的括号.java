import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
// @lc code=start
class Solution {
  public boolean isValid(String s) {
    Map<Character, Character> bracketMap = new HashMap<>(3);
    bracketMap.put('(', ')');
    bracketMap.put('[', ']');
    bracketMap.put('{', '}');

    if (s == null) {
      return false;
    }
    // 空字符串为有效括号
    if ("".equals(s)) {
      return true;
    }

    char tmp;
    tmp = s.charAt(0);
    // 获取字符串的第一个字符，如果为)、]、}，则该字符串不是有效括号
    if (tmp == ')' || tmp == ']' || tmp == '}') {
      return false;
    }

    Stack<Character> bracketStack = new Stack<>();
    bracketStack.push(tmp);
    for (int i = 1; i < s.length(); i++) {
      tmp = s.charAt(i);
      if (bracketMap.containsKey(tmp)) {
        bracketStack.push(tmp);
      } else {
        if (!bracketStack.isEmpty() && bracketMap.get(bracketStack.peek()).equals(tmp)) {
          bracketStack.pop();
        } else {
          return false;
        }
      }
    }

    return bracketStack.isEmpty();
  }
}
// @lc code=end
