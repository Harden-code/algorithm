package org.harden.coder.recursion;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/20 22:06
 * 文件说明：
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class WaysToStep {
    private int[] mem;
    /**
     *  楼数量抽象成方法 比如 3层代表三种走法
     *  2代表两种走法
     *  1代表一种走法
     */
    public int waysToStep(int n) {
        //会多出3
        mem=new int[n+3];
        return recursion(n);
    }

    private int recursion(int n){
        if(n==1){
            return 1;
        }
        // 1 1  2
        if(n==2){
            return 3;
        }
        //3 1,1,1 1,2 2,1
        if (n==3){
            return 4;
        }

        if(mem[n]!=0){
            return mem[n];
        }
        //fn=fn-1+fn-2+fn-3
        mem[n]=((recursion(n-1)%1000000007+recursion(n-2))%1000000007+recursion(n-3)%1000000007)%1000000007;
        return mem[n] ;
    }
}
