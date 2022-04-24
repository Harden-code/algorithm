//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 👍 68 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author junsenfu
 * @date 2022-04-11 21:22:47
 */
class CalculatorLcci {
    public static void main(String[] args) {
        Solution solution = new CalculatorLcci().new Solution();
//        String str="3+2*2";
//        String str = "3+5 / 2";
//        String str = "42";
//        String str = "3/2";
//        String str = "1-1+1";
//        String str="1+1-1";
//        String str="14/3*2";
        String str = "(1+2)*5+3+(2+3)*2";
        System.out.println(solution.calculate3(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //单调栈 栈中的元素优先级必须单调递增
        public int calculate(String s) {
            //消消乐问题 栈中转入的是不能消除的元素
            ArrayDeque<Integer> nums = new ArrayDeque<>();
            ArrayDeque<Character> ops = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    continue;
                } else if (isNum(c)) {
                    //加入数组 42
                    int num = c - '0';
                    if (i - 1 >= 0 && isNum(s.charAt(i - 1))) {
                        int pop = nums.pop();
                        nums.push(pop * 10 + num);
                    } else {
                        nums.push(num);
                    }
                } else {
                    //c == '+' || c == '-' || c == '*' || c == '/'
                    //为空 如果栈顶元素比当前元素小 就加入操作栈
                    if (ops.isEmpty() || isPriority(c, ops.peek())) {
                        ops.push(c);
                        continue;
                    }
                    //case1：当栈顶元素优先级大于当前元素就先入队,此时不知道后面还有什么元素
                    //case2：当栈顶元素优先级小于等于当前元素就可以先把前面当进行操作
                    //9+10*2+7
                    //  nums ops
                    //    2                   7
                    //   10  *  =》 20    =》 29   +
                    //   9   +      9  +

                    while (!ops.isEmpty() && !isPriority(c, ops.peek())) {
                        char o = ops.pop();
                        int num1 = nums.pop();
                        int num2 = nums.pop();
                        //倒序
                        int operation = operation(o, num2, num1);
                        nums.push(operation);
                    }
                    ops.push(c);
                }
            }
            //计算剩余的 1-1+1

            while (!ops.isEmpty()) {
                char pop = ops.pop();
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(operation(pop, num2, num1));
            }
            return nums.pop();
        }


        private boolean isNum(char c) {
            if ('0' <= c && c <= '9') {
                return true;
            }
            return false;
        }

        private boolean isPriority(char a, char b) {
            if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
                return true;
            }
            return false;
        }

        private int operation(char ops, int num1, int num2) {
            int result = 0;
            switch (ops) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            return result;
        }

        //带括号的
        public int calculate3(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<Character> ops = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    continue;
                } else if (isNum(c)) {
                    int cur = c - '0';
                    if (i - 1 >= 0 && isNum(s.charAt(i - 1))) {
                        int pop = nums.pop();
                        nums.push(pop * 10 + cur);
                    } else {
                        nums.push(cur);
                    }

                } else if (c == '(') {
                    ops.push(c);
                } else if (c == ')') {
                    //全部进行处理

                    while (!ops.isEmpty() && ops.peek() != '(') {
                        char o = ops.pop();
                        int num1 = nums.pop();
                        int num2 = nums.pop();
                        //倒序
                        int operation = operation(o, num2, num1);
                        nums.push(operation);
                    }
                    if (ops.peek() == '(') {
                        ops.pop();
                    }

                } else {
                    //符号
                    //当前元素优先级比 栈顶元素高 入栈不能消除
                    if (ops.isEmpty() || (isPriority(c, ops.peek())&&c!='(')) {
                        ops.push(c);
                        continue;
                    }
                    //当前元素小于等于栈顶元素的进行消除
                    while (!ops.isEmpty() && !isPriority(c, ops.peek())&&ops.peek()!='(') {
                        char o = ops.pop();
                        int num1 = nums.pop();
                        int num2 = nums.pop();
                        //倒序
                        int operation = operation(o, num2, num1);
                        nums.push(operation);
                    }
                    ops.push(c);
                }
            }
            while (!ops.isEmpty()) {
                char o = ops.pop();
                int num1 = nums.pop();
                int num2 = nums.pop();
                //倒序
                int operation = operation(o, num2, num1);
                nums.push(operation);
            }
            return nums.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}