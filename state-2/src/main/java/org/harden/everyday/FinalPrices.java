package org.harden.everyday;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/1 10:00
 * 文件说明： </p>
 */
public class FinalPrices {
    //1475. 商品折扣后的最终价格
    public static int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        //单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            //栈里单调递增
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int peek = stack.peek();
                result[peek] = prices[peek] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            result[pop] = prices[pop];
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        //[4,2,4,2,3]
//        int[] nums = {8, 4, 6, 2, 3};
        int[] nums={10,1,1,6};
        finalPrices(nums);
    }
}
