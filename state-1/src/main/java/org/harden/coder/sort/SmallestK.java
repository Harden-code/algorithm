package org.harden.coder.sort;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 19:22
 * 文件说明：
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * </p>
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        return null;
    }

    public void reverse(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int position = position(arr, p, r);
        reverse(arr, p, position);
        reverse(arr, position + 1, r);
    }

    public int position(int[] arr, int p, int r) {
        int i = p;
        int j = r - 1;
        int value = arr[r];
        while (i < j) {
            if (arr[i] > value) {
                swap(arr, i, j);
                i++;
                j--;
            }
            if (arr[j] < value) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr,j,r);
        return j;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
