package org.harden.coder.queue;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/18 18:46
 * 文件说明：
 * 请根据每日 气温 列表 temperatures ，
 * 请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。</p>
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] t) {
        int[] result = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length; i++) {
            //栈中值存小的第二个的数 出栈条件 栈始终保持单调递减
            while(!stack.isEmpty()&&t[stack.peek()]<t[i]){
                //取出栈顶元素
                Integer index=stack.pop();
                //栈顶元素为 下标 大于-index
                result[index]=i-index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] b={55,38,53,81,61,93,97,32,43,78};
        int[] a={73,74,75,71,69,72,76,73};
        dailyTemperatures(a);
    }
}
