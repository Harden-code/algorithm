//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3343 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author  junsenfu
 * @date 2022-04-14 21:19:40
 */
class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
//        int[] nums={0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] nums={4,2,0,3,2,5};
        int[] nums={4,2,0,3,2,4,3,4};
        System.out.println(solution.trap(nums));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int result=0;
        //栈中始终保持单调递减
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int cur=height[i];
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            //栈顶元素等于大于当前元素 进栈
            if(height[stack.peek()]>=cur){
                stack.push(i);
            }else{

                //处理特殊情况 当栈中只有一个元素
                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }
                //保持栈中元素始终 单调递减 剔除栈中比当前元素小的值
                while (!stack.isEmpty()&&height[stack.peek()]<cur){
                    int first=stack.pop();
                    if(!stack.isEmpty()){
                        int second=stack.peek();
                        int min = Math.min(height[second], cur)-height[first];
                        //
                        int temp=(i-second-1)*min;
                        result+=temp;
                    }

                }
                if(stack.isEmpty()||height[stack.peek()]>=cur){
                    stack.push(i);
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}