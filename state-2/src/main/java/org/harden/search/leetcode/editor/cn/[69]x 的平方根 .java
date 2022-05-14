//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 1008 👎 0

package org.harden.search.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-05-12 21:24:35
 */
class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        solution.mySqrt(8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            //求最小
            int low = 0;
            int height = x / 2 + 1;
            while (low <= height) {
                int mid = low + (height - low) / 2;
                long all = (long) mid * mid;
                if (all >= x) {
                    //探测
                    long all2 = (long) (mid - 1) * (mid - 1);
                    if (all == x ) {
                        return mid;
                    } else if(all2 < x){
                        //下一个在区间内
                        return mid-1;
                    }else {
                        height = mid - 1;
                    }
                } else {

                    low = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}