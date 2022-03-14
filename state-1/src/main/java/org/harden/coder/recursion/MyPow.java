package org.harden.coder.recursion;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/20 22:40
 * 文件说明： 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * </p>
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(n>0){
            return recursion1(x,n);
        }
        return recursion2(x,-n);
    }

    /**
     * fn=fn-1*fn-1
     */
    public double recursion1(double x ,int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }

        return recursion1(x,n-1)*x;
    }
    public double recursion2(double x ,int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }

        return 1/recursion2(x,n-1)*1/x;
    }
}
