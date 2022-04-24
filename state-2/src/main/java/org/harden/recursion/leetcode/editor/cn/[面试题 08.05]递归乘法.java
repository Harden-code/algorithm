//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 位运算 递归 数学 👍 64 👎 0

package org.harden.recursion.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-04-23 22:49:54
 */
class RecursiveMulitplyLcci{
    public static void main(String[] args) {
        Solution solution = new RecursiveMulitplyLcci().new Solution();
        System.out.println(solution.multiply(3, 4));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 输入：A = 3, B = 4
    // 输出：12
    public int multiply(int A, int B) {
        return multiply_r(A,B);
    }

    private int multiply_r(int a,int b){
        //等于0 会多出一位
        if(b==1){
            return a;
        }
        //fn=fn-1+a
        return multiply(a, b-1)+a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}