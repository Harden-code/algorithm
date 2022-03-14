package org.harden.coder.sort;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/23 20:28
 * 文件说明：冒泡排序 </p>
 */
public class Sort {
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= nums.length - 1; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //保留插入的那位
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    //左移
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        return nums;
    }

    public static int[] mergerSort(int[] nums) {
        int len = nums.length-1;
        merger(nums, 0, len);
        return nums;
    }

    public static void merger(int[] nums, int p, int r) {
        //结束条件
        if (p >= r) {
            return;
        }
        //q 是变动的
        int q = p + (r - p) / 2;
        merger(nums, p, q);
        merger(nums, q + 1, r);
        sort(nums, p, q, r);
    }

    public static void sort(int[] nums, int p, int q, int r) {
        //新数组下标
        int k = 0;
        //用来存储中间节点
        int j = q + 1;
        //记录p下标
        int i = p;
        int[] temp = new int[r - p + 1];
        while (i <=q && j <= r) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            }else{
                temp[k++] = nums[i++];
            }
        }
        //处理未加完的

        while (i <= q) {
            temp[k++] = nums[i++];
        }

        while (j <= r) {
            temp[k++] = nums[j++];
        }
        //r-p
        for (i = 0; i <= r-p; i++) {
            nums[p+i] = temp[i];
        }
    }

    public static void quickSort(int[] nums){
        reverse(nums,0,nums.length-1);
    }

    public static void reverse(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int position = position(arr, p, r);
        reverse(arr, p, position);
        reverse(arr, position + 1, r);
    }

    public static int position(int[] arr, int p, int r) {
        int i = p;
        int j = r - 1;
        int value = arr[r];
        while (i < j) {
            if (arr[i] < value) {
                i++;
            }
            if (arr[j] > value) {
                j--;
            }
            if(i<j){
                swap(arr,j,r);
            }
        }
        if(arr[j]>arr[r]){
            swap(arr,j,r);
        }else {
            swap(arr,j+1,r);
        }
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 0, 4, 7, 6};

        bubbleSort(nums);

        String insertSort = Arrays.stream(nums).boxed().map(e -> Integer.toString(e))
                .collect(Collectors.joining(","));

        System.out.println(insertSort);


    }
}
