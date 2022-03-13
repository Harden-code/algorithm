package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/29 23:25
 * 文件说明：
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low=1;
        int height = num;
        while (low <= height) {
            int mid=low+(height-low)/2;
            long i=(long)mid*mid;
            if(i==num){
                return true;
            }else if(i<num){
                low=mid+1;
            }else {

                height=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println(isPerfectSquare.isPerfectSquare(16));
    }
}
