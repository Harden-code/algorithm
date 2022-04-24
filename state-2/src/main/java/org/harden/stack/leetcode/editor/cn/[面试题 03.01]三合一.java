//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
//stackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
// 
// 输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
// 
// 输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= stackNum <= 2 
// 
// Related Topics 栈 设计 数组 👍 48 👎 0

package org.harden.stack.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-04-06 22:05:08
 */
class ThreeInOneLcci{
    public static void main(String[] args) {
        TripleInOne solution = new ThreeInOneLcci().new TripleInOne(18);
        solution.push(2,40);
        solution.pop(2);


    }
//leetcode submit region begin(Prohibit modification and deletion)
class TripleInOne {
    /**
     * 测试结果:[null,-1,-1,true,null,40,null,null,44,null,null,false,54,1,null,-1,false,-1,-1,null,false,15,2,-1,56,1,false,42,null,false,1,null,-1,false,false,false,false,2,null,null,-1,false,3,false,null,null,null,1,5,11,null,null,false,-1,63,null,2,6,36,false,39,2,-1,null,null]
     * 期望结果:[null,-1,-1,true,null,40,null,null,44,null,null,false,54,40,null,-1,false,-1,-1,null,false,15,56,-1,56,42,false,42,null,false,32,null,-1,false,false,false,false,30,null,null,-1,false,56,false,null,null,null,11,3,11,null,null,false,-1,63,null,40,39,36,false,39,40,-1,null,null]
     * */
    private final int[] ints;

    private final int[] count=new int[3];

    private final int size;
    public TripleInOne(int stackSize) {
        this.ints=new int[3*stackSize];
        this.size=stackSize;
    }
    
    public void push(int stackNum, int value) {
        if(count[stackNum]==size)return;
        ints[stackNum*size+count[stackNum]]=value;
        count[stackNum]++;
    }
    
    public int pop(int stackNum) {
        if(count[stackNum]==0)return -1;
        int value=ints[stackNum*size+count[stackNum]-1];
        count[stackNum]--;
        return value;
    }
    
    public int peek(int stackNum) {
        if(count[stackNum]==0)return -1;
        return ints[stackNum*size+count[stackNum]-1];
    }
    
    public boolean isEmpty(int stackNum) {
        return count[stackNum]==0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

}