//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2738 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author junsenfu
 * @date 2022-07-06 23:35:24
 */
class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> list = solution.generateParenthesis(3);
        list.forEach(System.out::println);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            backTrace(new StringBuilder(), n, 0, 0);
            return result;
        }

        private void backTrace(StringBuilder path, int n, int left, int right) {

            //(())
            if (path.length() == n * 2) {
                System.out.println(left+":"+right);
                result.add(path.toString());
                return;
            }

            if (left < n) {
                // ( ( left 1 2
                path.append("(");
                backTrace(path, n, left + 1, right);
                //( 2 end
                path.deleteCharAt(path.length() - 1);
            }

            if (right < left) {
                // ) ) 1 2
                path.append(")");
                backTrace(path, n, left, right + 1);
                //))
                path.deleteCharAt(path.length() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}