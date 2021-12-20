package org.harden.coder.queue;

import java.sql.Statement;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/14 21:38
 * 文件说明：
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、
 * peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class TripleInOne {
        private int[][] stacks;

        private int len;

        private int[] counts;

        public TripleInOne(int stackSize) {
            this.stacks=new int[3][stackSize];
            this.counts=new int[]{0,0,0};
            this.len=stackSize;
        }

        /**
         * 先进
         */
        public void push(int stackNum, int value) {
            int[] stack=stacks[stackNum];
            if(counts[stackNum]==len){
                return;
            }
            stack[counts[stackNum]]=value;
            counts[stackNum]++;
        }

        /**
         * 后出
         */
        public int pop(int stackNum) {
            int[] stack=stacks[stackNum];
            if(counts[stackNum]==0){
                return -1;
            }

            int value=stack[counts[stackNum]-1];
            counts[stackNum]--;
            return value;
        }

        public int peek(int stackNum) {
            if(counts[stackNum]==0){
                return -1;
            }
            return stacks[stackNum][counts[stackNum]-1];
        }

        public boolean isEmpty(int stackNum) {
            return counts[stackNum]==0;
        }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(18);
        tripleInOne.push(2,40);
        tripleInOne.push(0,44);
        tripleInOne.push(1,40);
        tripleInOne.push(1,54);
        tripleInOne.push(0,42);
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(1));
        System.out.println(tripleInOne.pop(1));
        System.out.println("x");
    }
}
