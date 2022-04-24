//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：
//push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。 
//
// 示例1: 
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
// 
//
// 示例2: 
//
//  输入： 
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
// 
//
// 说明: 
//
// 
// 栈中的元素数目在[0, 5000]范围内。 
// 
// Related Topics 栈 设计 单调栈 👍 61 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author junsenfu
 * @date 2022-04-06 21:03:51
 */
class SortOfStacksLcci {
    public static void main(String[] args) {
        SortedStack solution = new SortOfStacksLcci().new SortedStack();
        solution.push(1);
        solution.push(2);
        solution.peek();
        solution.pop();
        solution.isEmpty();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SortedStack {
        private final Stack<Integer> stack = new Stack<>();

        private final Stack<Integer> tempStack = new Stack<>();

        private int min = Integer.MAX_VALUE;

        public SortedStack() {
        }

        public void push(int val) {
            //记录最小的
            if (val <= min) {
                min = val;
                stack.push(val);
            } else {
                int min_ = stack.pop();
                stack.push(val);
                stack.push(min_);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;
            stack.pop();
            min = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (pop <= min) {
                    min = pop;
                }
                tempStack.push(pop);
            }
            boolean flag = false;
            while (!tempStack.isEmpty()) {
                int pop = tempStack.pop();
                //特殊情况 元素里有两个相同的值
                if (!flag && pop == min) {
                    flag = true;
                    continue;
                }
                stack.push(pop);
            }
            if (Integer.MAX_VALUE != min) {
                stack.push(min);
            }
        }

        /**
         * 测试结果:[null,-1,null,null,false,false,64,64,false,64,false,null,null,true,true,true,-1,-1,-1,true,null,52,null,null,5,false,null,false,null,44,false,false,44,null,null,null,39,null,39,null,null,false,null,1,false,null,null,false,false,null,null,null,74,null,6,false,false,false,null,null,null,74,74,74,74,null,false,false,false,null
         * ,true,-1,true,-1,null,null,true,-1,null,null,18,null,null,false,null,35,null]
         * 期望结果:[null,-1,null,null,false,false,64,64,false,64,false,null,null,true,true,true,-1,-1,-1,true,null,52,null,null,5,false,null,false,null,44,false,false,44,null,null,null,39,null,39,null,null,false,null,1,false,null,null,false,false,null,null,null,74,null,6,false,false,false,null,null,null,74,74,74,74,null,false,false,false,null,
         * false,84,false,84,null,null,true,-1,null,null,18,null,null,false,null,35,null]
         *
         * @return
         */
        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            }
            return min;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}