//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 344 👎 0

package org.harden.recursion.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-04-20 22:04:01
 */
class FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(43));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[] dump;
    public int fib(int n) {
        dump=new int[n+1];
        //规模更小的问题跟规模更大的问题解决思路是否相同
        //利用子问题的解可以组合得到原问题的解
        //存在最小子问题可以返回结果
        //fn=fn-1+fn-2
        return fib_r(n);
    }

    public int fib_r(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        //备忘录 避免重复计算
        if(dump[n]!=0){
            return dump[n];
        }
        int sum = (fib_r(n - 1) + fib_r(n - 2))%1000000007;
        dump[n]=sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}