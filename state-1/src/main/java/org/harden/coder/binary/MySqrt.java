package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/30 20:24
 * 文件说明：
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 输入：x = 4
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 */
public class MySqrt {

    public int mySqrt(int x) {
        int low = 0;
        //x 1
        int height = x/2+1 ;
        int ans=-1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            long i = (long) mid * mid;
            if (i <= x) {
                ans=mid;
                low = mid +1;
            } else {

                height=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(36));
    }
}
