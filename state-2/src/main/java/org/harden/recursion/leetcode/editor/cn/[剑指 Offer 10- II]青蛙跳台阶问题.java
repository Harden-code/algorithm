//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 275 👎 0

package org.harden.recursion.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-20 22:19:57
 */
class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] dump;
        public int numWays(int n) {
            dump=new int[n+1];
            return fib(n);
        }

        public int fib(int n) {
            if(n==0){
                return 1;
            }
            //一个台阶 只能有一种走法
            if(n==1){
                return 1;
            }
            //两个台阶 有两种走法
            if(n==2){
                return 2;
            }
            if(dump[n]!=0){
                return dump[n];
            }
            //原问题 fn=fn-1+fn-2
            int sum=(fib(n-1)+fib(n-2))%1000000007;
            dump[n]=sum;
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}