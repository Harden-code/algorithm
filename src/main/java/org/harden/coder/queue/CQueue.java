package org.harden.coder.queue;

import java.lang.ref.PhantomReference;
import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/14 21:37
 * 文件说明：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 
 *  操作返回 -1 )
 *
 *  输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class CQueue {

    private Stack<Integer> stack;

    private Stack<Integer> temp;

    public CQueue() {
        stack=new Stack<>();
        temp=new Stack<>();
    }

    /**
     * 1.把之前存入的放入临时栈，在加入新元素，把临时栈的在放回
     * @param value
     */
    public void appendTail(int value) {
        while(!stack.empty()){
            //让之前入队的先放入 临时栈
            temp.push(stack.pop());
        }
        stack.push(value);

        while (!temp.empty()){
            stack.push(temp.pop());
        }


    }


    public int deleteHead() {
        int value=-1;
        if(!stack.empty()){
            value=stack.pop();
        }
        return value;
    }

    /**
     * 2.出队保持顺序
     * 出栈 先把stack里的元素push到temp
     * 在从temp里的pop出放回stack
     */
    public int deleteHead2(){
        int value=-1;
        if(stack.empty()){
            return value;
        }
        while (!stack.empty()){
            temp.push(stack.pop());
        }
        value=temp.pop();
        while (!temp.empty()){
            stack.push(temp.pop());
        }
        return value;
    }
    public void appendTail2(int value) {
        stack.push(value);
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        cQueue.deleteHead();
        cQueue.deleteHead();
    }
}
