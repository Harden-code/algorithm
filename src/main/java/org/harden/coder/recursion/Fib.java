package org.harden.coder.recursion;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/20 21:39
 * 文件说明：
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的定义如下：
 * 输入：n = 2
 * 输出：1
 * </p>
 */
public class Fib {

    private int[] ints;

    public int fib(int n) {
        ints=new int[n+1];
        return recursion(n);
    }

    private int recursion(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        //fn=fn-1+fn-2
        if(ints[n]!=0){
            return ints[n];
        }
        ints[n]= (recursion(n-1)+recursion(n-2)%1000000007);
        return  ints[n];
    }
}
