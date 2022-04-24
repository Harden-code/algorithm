//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 79 👎 0

package org.harden.recursion.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-04-20 22:28:30
 */
class ThreeStepsProblemLcci{
    public static void main(String[] args) {
        Solution solution = new ThreeStepsProblemLcci().new Solution();
        System.out.println(solution.waysToStep(3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[] dump;
    public int waysToStep(int n) {
        dump=new int[n+1];
        return fib(n);
    }

    public int fib(int n) {
        if(n==1||n==0){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            //1 1 1 1 / 1 1 2  /2 2 /2 1 1
            return 4;
        }
        if(dump[n]!=0){
            return dump[n];
        }
        //fn拆封成是三个子问题fn-1 fn-2 fn-3
        int sum=((fib(n-1)+fib(n-2))%1000000007+fib(n-3))%1000000007;
        dump[n]=sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}