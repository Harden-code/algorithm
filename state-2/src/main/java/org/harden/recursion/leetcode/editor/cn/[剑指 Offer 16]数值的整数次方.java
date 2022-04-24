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


        System.out.println(solution.myPow(2, 10));
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
                return pow_r(1/x,-n);
            }
        }

        private double pow_r(double x,int n){
            if(n==1){
                return x;
            }
            if(n/2==1){
                return pow_r(x,n/2)*pow_r(x,n/2);
            }else {
                return pow_r(x,n-1)*x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}