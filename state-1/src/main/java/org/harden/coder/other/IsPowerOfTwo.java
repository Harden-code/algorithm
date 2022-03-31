package org.harden.coder.other;

/**
 * 231. 2 的幂
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        int mask=1;
        while (n!=1){
            int j = mask & n;
            if(j!=0){
                return false;
            }
            n>>=mask;
            System.out.println(n);
        }
        return true;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(-16));
    }
}
