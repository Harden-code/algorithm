//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 292 👎 0

package org.harden.recursion.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-23 22:20:07
 */
class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();


//        System.out.println(8>>2);
        System.out.println(solution.myPow(0.00001, 2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        //输入：x = 2.00000, n = -2    x = 2.00000, n = 10
        //输出：0.25000                1024.00000
        //解释：2⁻² = 1/2² = 1/4 = 0.25
        //使用减栈太深
        public double myPow(double x, int n) {
            //两种情况正 负
            if(n>=0){
               return pow_r(x,n);
            }else {
                // x=2.00000 n=-2147483648 先算出来再惩
                return 1/(pow_r(x, -1*(n+1)) *x);
            }
        }

        private double pow_r(double x,int n){
            //0 特殊情况
            if(n==0){
                return 1;
            }
            if(n==1){
                return x;
            }
            //左移1 除2
            double result=pow_r(x,n>>1);

            if((n&1)==1){
                //基数
               return result*result*x;
            }else {
                return result*result;
            }

            //递归次数太多会超时
//            if(n/2!=0&&n%2!=0){
//                //奇数
//              return pow_r(x,n/2)*pow_r(x,n/2)*x;
//            }else {
//                //偶数
//                return pow_r(x,n/2)*pow_r(x,n/2);
//            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}