package org.harden.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/13 14:04
 * 文件说明： 670. 最大交换 </p>
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> nums = new ArrayList<>();
        int i = 112;
        while (i != 0) {
            nums.add(i % 10);
            i /= 10;
        }
        int result = 0;
        for (int j = nums.size() - 1; j >= 0; j--) {
            result = result * 10 + nums.get(j);
        }
        return result;
    }

    private void swap(List<Integer> nums,int i,int j){

    }
    public static void main(String[] args) {

    }
}
