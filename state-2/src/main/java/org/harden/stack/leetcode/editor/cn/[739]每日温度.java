//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1108 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author  junsenfu
 * @date 2022-04-13 22:12:10
 */
class DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        int[] nums={73,74,75,71,69,72,76,73};
        solution.dailyTemperatures(nums);
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dump=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        //单调栈，栈中只记录的温度是下降趋势
        //栈中的元素记录下标
        //遍历与栈顶比较 比栈顶小的放入，栈顶大的进行操作
        for (int i = 0; i < temperatures.length; i++) {
            //记录下标
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(temperatures[stack.peek()]>temperatures[i]){
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty()&&temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                dump[pop]=i-pop;
            }
            stack.push(i);

        }

        return dump;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}