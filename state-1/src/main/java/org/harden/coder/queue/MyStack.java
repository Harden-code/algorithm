package org.harden.coder.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/14 21:35
 * 文件说明：
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> temp;
    public MyStack() {
        queue=new ArrayDeque<>();
        temp=new ArrayDeque<>();
    }

    public void push(int x) {
        while(!queue.isEmpty()){
            temp.offer(queue.poll());
        }
        queue.offer(x);
        while(!temp.isEmpty()){
            queue.offer(temp.poll());
        }
    }

    public int pop2() {
        Integer value=null;
        while (!queue.isEmpty()&&queue.size()!=1){
            temp.offer(queue.poll());
        }
        value=queue.poll();
        while (!temp.isEmpty()){
            queue.offer(temp.poll());
        }
        return value;
    }

    public void push2(int x) {
        queue.offer(x);
    }

    public int top2() {
        Integer value=null;
        while (!queue.isEmpty()&&queue.size()!=1){
            temp.offer(queue.poll());
        }
        value=queue.peek();
        temp.offer(queue.poll());
        while (!temp.isEmpty()){
            queue.offer(temp.poll());
        }
        return value;
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push2(1);
        myStack.push2(2);
        myStack.top2();

    }
}
