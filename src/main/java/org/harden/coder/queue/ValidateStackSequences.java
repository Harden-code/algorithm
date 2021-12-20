package org.harden.coder.queue;

import java.sql.Statement;
import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/18 15:16
 * 文件说明：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
 * 就不可能是该压栈序列的弹出序列。
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //特殊情况
        if (popped.length == 0) {
            return true;
        }
        //pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        // 1,2,3,4  pop 4 相等 就把栈顶去除，popped后移动
        // 1,2,3  pop 3
        //1,2,5

        Stack<Integer> stack = new Stack<>();
        //j记录pop下标
        int j = 0;
        for (int i = 0 ; i < pushed.length; i++) {
            int push = pushed[i];
            int pop = popped[j];
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == pop ) {
                stack.pop();
                //防止越界
                if(j >= popped.length-1){
                    break;
                }
                pop = popped[++j];
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {4, 3, 5, 2, 1};
//        int[] a = {0, 6, 8, 9, 1, 3, 2, 5, 4, 7};
//        int[] b = {6, 0, 4, 9, 1, 2, 3, 7, 8, 5};
        int[] a={1,0};
        int[] b={1,0};
        System.out.println(validateStackSequences(a, b));
    }
}
