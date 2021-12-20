package org.harden.coder.queue;

import javafx.scene.chart.ValueAxis;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/14 21:39
 * 文件说明：
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class SortedStack {
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> temp = new Stack<>();

    public SortedStack() {
    }

    public void push(int val) {
        //1.没有情况
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        //2.先从原始取出判断
        while(!stack.isEmpty()){
            int value=stack.peek();
            if(value<val){
                temp.push(stack.pop());
            }else {
                break;
            }
        }
        stack.push(val);
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }

    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    public int peek() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.peek();
        sortedStack.pop();
        sortedStack.peek();
    }
}
