//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 队列 👍 496 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author junsenfu
 * @date 2022-04-06 20:36:44
 */
class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        //栈的特点：后进后出
        //队列特点：先进先出

        private final Stack<Integer> stack = new Stack<>();

        private final Stack<Integer> tempStack = new Stack<>();

        public CQueue() {
        }

        //方法2 在进栈的时候让两个栈进行倒转
        public void appendTail1(int value) {
            //先让原有的放在临时栈中
            while (!stack.isEmpty()){
                tempStack.push(stack.pop());
            }
            //在把进来的元素放入stack，让它在最下面（后进先出）
            stack.push(value);
            //再把原有的放回去
            while (!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
        }

        public int deleteHead1() {
            if(stack.isEmpty()){
                return -1;
            }
            return stack.pop();
        }

        public void appendTail(int value) {
           stack.push(value);
        }

        //方法1 在出栈的时候让两个栈进行倒转
        public int deleteHead() {
            if(stack.isEmpty()){
                return -1;
            }
            while (!stack.isEmpty()){
                tempStack.push(stack.pop());
            }
            int value=tempStack.pop();
            while (!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
            return value;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}