package org.harden.coder.other;

import java.util.Arrays;

/**
 * 面试题 16.06. 最小差
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 */
public class SmallestDifference {

    public int smallestDifference(int[] a, int[] b) {
        long result = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        while (i <a.length  && j <b.length ) {
            if (a[i] > b[j]) {
                result = Math.min(result,(long)a[i]-b[j]);
                j++;
            } else if (a[i] < b[j]) {
                result = Math.min(result,(long)b[j]-a[i]);
                i++;
            }else {
                 return 0;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {

        System.out.println( Math.abs(Math.subtractExact(-2147483648, 2147483647)));
    }
}
