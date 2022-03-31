package org.harden.coder.other;

/**
 * 面试题 05.07. 配对交换
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 */
public class ExchangeBits {
    public int exchangeBits(int num) {
        int[] bits = new int[31];
        //先转成二进制
        int mask = 1;
        int k = 0;
        while (num != 0) {
            bits[k++] = num & mask;
            num >>= mask;
        }
        //在转换为十进制
        int i = 0;
        int j = k - 1;
        while (i <= j) {
            int tem = bits[i];
            bits[i] = bits[j];
            bits[j] = tem;
            i++;
            j--;
        }
        int result = 0;
        //低位 为0
        for (j = k - 1; j >= 0; j--) {
            result = (result << 1) + bits[j];
        }
        return result;
    }

    public static void main(String[] args) {
        ExchangeBits exchangeBits = new ExchangeBits();
        System.out.println(exchangeBits.exchangeBits(2));
    }
}
