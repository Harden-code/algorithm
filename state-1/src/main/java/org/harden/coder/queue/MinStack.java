package org.harden.coder.queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/14 21:38
 * 文件说明：
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class MinStack {

    private LinkedList<Integer> stack=new LinkedList();

    private LinkedList<Integer> temp=new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        int min=stack.peek();
        while(!stack.isEmpty()){
            int value=stack.peek();
            temp.push(stack.pop());
            if(min>value){
                min=value;
            }
        }
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return min;
    }
}
