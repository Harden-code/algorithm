package org.harden.everyday;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/8/31 11:41
 * 文件说明： </p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode.cn/problems/validate-stack-sequences
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateStackSequences {
    /**
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     */
    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] pushed ={1,2,3,4,5};
        int[]popped = {4,5,3,2,1};
        //[2,1,0]
        //[1,2,0]
//        int[] pushed = {2, 1, 0};
//        int[] popped = {1, 2, 0};
        validateStackSequences.validateStackSequences(pushed, popped);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        //记录popped下标
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            //先压入
            stack.push(pushed[i]);

            while (!stack.isEmpty()) {
                int val = stack.peek();
                //通过弹出看是否与popped的元素相等
                if (val == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }

        }
        return stack.isEmpty();
    }
}
