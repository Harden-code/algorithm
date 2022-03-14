package org.harden.coder.recursion;

import java.lang.ref.PhantomReference;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/20 23:19
 * 文件说明：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入：n = 2
 * 输出：2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class NumWays {

    private int[] mem;
    public int numWays(int n) {
        mem=new int[n+2];
        return recursion(n);
    }

    public int recursion(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(mem[n]!=0){
            return mem[n];
        }
        mem[n]=(recursion(n-1)%1000000007+recursion(n-2)%1000000007)%1000000007;
        return mem[n];
    }
}
