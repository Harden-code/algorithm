package org.harden.everyday;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 */
public class SpecialArray {
    public int specialArray(int[] nums) {
        int result = -1;
        Arrays.sort(nums);
        int[] dump = new int[nums.length];
        for (int i = 0; i < dump.length; i++) {
            dump[i] = dump.length - i;
        }
        //特殊情况 [0,0] [100,100]
        if(dump[0]<=nums[0]&&nums[0]==nums[nums.length-1]){
            return dump[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val >= dump[i]) {
                int j = i - 1;
                //判断前面元素是否 大于当前元素
                boolean flag = false;
                while (j >= 0) {
                    //因为排序了
                    if (nums[j] >= dump[i])
                        break;
                    else flag = true;
                    j--;
                }
                if (flag) {
                    return dump[i];
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
//        int[] nums={ 1,6,7,7,5};
        int[] nums = {3, 6, 7, 7, 0};
        System.out.println(specialArray.specialArray(nums));
    }
}
