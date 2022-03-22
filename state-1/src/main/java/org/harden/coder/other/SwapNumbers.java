package org.harden.coder.other;

/**
 * 面试题 16.01. 交换数字
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 */
public class SwapNumbers {
    public int[] swapNumbers(int[] numbers) {
        // ^异或 1 1 为0
        //  01 10 = 11
        numbers[0]=numbers[0]^numbers[1];
        //  11 10=01
        numbers[1]=numbers[0]^numbers[1];
        // 01 11=10
        numbers[0]=numbers[0]^numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(1|2);
        System.out.println((1|2)^1);
    }
}
