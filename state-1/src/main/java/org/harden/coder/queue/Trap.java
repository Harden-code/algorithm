package org.harden.coder.queue;

import java.security.interfaces.RSAKey;
import java.util.Stack;
import java.util.logging.Level;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/18 18:51
 * 文件说明：
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/yi-miao-jiu-neng-du-dong-de-dong-hua-jie-o9sv/
 * </p>
 */
public class Trap {
    public static int trap(int[] height) {
        int result = 0;
        //单调栈，保留递减的数进栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            //栈中只存取 递减的
            while (!stack.isEmpty()) {
                int top=stack.peek();
                //相等取出移动
                if(height[top]==height[i]){
                    stack.pop();
                    stack.push(i);
                    break;
                //直接进
                }else if(height[top]>height[i]){
                    stack.push(i);
                    break;
                //有槽
                }else {
                    Integer mid = stack.pop();
                    //当第一个为0时
                    if(stack.isEmpty()){
                        stack.push(i);
                        break;
                    }
                    //只判断 中间槽和 i
                    Integer left = stack.peek();
                    //找中间值
                    int h= Math.min(height[i],height[left])-height[mid];
                    int w=i-left-1;
                    result+=h*w;

                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] b={4,2,0,3,2,5};
        System.out.println(trap(b));
    }
}
