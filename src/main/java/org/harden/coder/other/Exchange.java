package org.harden.coder.other;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        while (begin < end) {
           if(nums[begin]%2!=0){
               begin++;
               continue;
           }
           if(nums[end]%2==0){
               end--;
               continue;
           }
            swap(begin,end,nums);
        }
        return nums;
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int[] a = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        exchange.exchange(a);
        System.out.println(Arrays.toString(a));
    }
}
