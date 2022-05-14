//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 385 👎 0

package org.harden.search.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-05-12 21:15:41
 */
class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        solution.isPerfectSquare(808201);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：num = 16
        //输出：true
        public boolean isPerfectSquare(int num) {
            //二分匹配
            int low=0;
            int height=num/2+1;
            while (low<=height){
                int mid=low+(height-low)/2;
                //溢出
                long all=(long) mid*mid;
                if(all==num){
                    return true;
                }else if(all<num){
                    low=mid+1;
                }else {
                    height=mid-1;
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}