package org.harden.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 670. 最大交换
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> nums = new ArrayList<>();
        int i = num;
        while (i != 0) {
            nums.add(i % 10);
            i /= 10;
        }
        //交换比第一个大
        int max = -1;
        //需要交换到下标
        int index = 0;

        //find 最大
        boolean finded=false;
        for (int j = nums.size() - 1; j >= 0; j--) {
            int val = nums.get(j);
            if (val != 9) {
                for (int p = 0; p <j; p++) {
                    int valp = nums.get(p);
                    if (valp > val) {
                        index = j;
                        max = val;
                        finded=true;
                        break;
                    }
                }
                //找到剩下到就去掉
            }
            if(finded)break;
        }

        //交换到值
        int swap = -1;
        for (int j = 0; j <= index; j++) {
            if (max < nums.get(j)) {
                max = nums.get(j);
                swap = j;
            }
        }
        //swap
        if (swap != -1) {
            int temp = nums.get(index);
            nums.set(index, nums.get(swap));
            nums.set(swap, temp);
        }

        int result = 0;
        for (int j = nums.size() - 1; j >= 0; j--) {
            result = result * 10 + nums.get(j);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        maximumSwap.maximumSwap(2736);
    }
}
