package org.harden.coder.recursion;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/20 22:28
 * 文件说明：
 * 递归乘法。 写一个递归函数，不使用 * 运算符，
 * 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *  输入：A = 1, B = 10
 *  输出：10
 *  </p>
 */
public class Multiply {
    int sum=0;

    public int multiply(int A, int B) {

        return recursion(A,B);
    }

    /**
     *
     * a 2 b 6
     * fn=fn-1+a
     */
    public int recursion(int a, int b){
        if(b==1){
            return a;
        }
        int recursion = recursion(a, b/2);
        if(b%2==0){
            sum=recursion+recursion;
        }else {
            sum=recursion+recursion+a;
        }
        return sum;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.recursion(2, 10));
    }
}
