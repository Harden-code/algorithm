package org.harden.everyday;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/8 12:55
 * 文件说明： 667. 优美的排列 II</p>
 */
public class ConstructArray {
    public static int[] constructArray(int n, int k) {
        boolean[] bit = new boolean[n + 1];
        int i = k;
        int[] result = new int[n];
        result[0] = 1;
        bit[1] = true;
        int len = result.length - 1;
        int j = 1;
        while (i >= 1 && j <= len) {
            int a = result[j - 1] + i;
            int b = result[j - 1] - i; //b>0 剩余部分 选最小的进去排序
            //必须单调递增的走
            if (b > 0 && !bit[b] && b < result[j - 1]) {
                bit[b] = true;
                result[j] = b;
            } else if (a <= n && !bit[a]) {
                result[j] = a;
                bit[a] = true;
            }
            i--;
            j++;
        }
        //填充
        for (int p = 1; p < bit.length; p++) {
            if (!bit[p]) {
                result[j++] = p;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        constructArray(4, 3);
    }
}
