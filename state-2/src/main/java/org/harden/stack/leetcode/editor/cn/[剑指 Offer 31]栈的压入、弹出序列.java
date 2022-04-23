//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
// Related Topics 栈 数组 模拟 👍 320 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author junsenfu
 * @date 2022-04-13 21:25:24
 */
class ZhanDeYaRuDanChuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 3, 5, 1, 2};
        System.out.println(solution.validateStackSequences(pushed, poped));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int j = 0;
            while (i < pushed.length && j < pushed.length) {
                int push = pushed[i];
                int pop = popped[j];
                //不相等就先入栈
                if (pop != push) {
                    stack.push(push);
                } else {
                    stack.push(push);
                    //相等在入栈 然后于栈顶元素相比较，相同就出栈
                    while (!stack.isEmpty()) {
                        if (stack.peek() ==popped[j]){
                            stack.pop();
                            j++;
                        }else {
                            break;
                        }
                    }
                }
                i++;
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}