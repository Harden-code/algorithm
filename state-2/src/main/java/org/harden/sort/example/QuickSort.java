package org.harden.sort.example;

import java.util.Arrays;

public class QuickSort {

    public int[] quickSort(int[] arr){
        quickSort_r(arr,0,arr.length-1);
        return arr;
    }

    /**
     *
     * @param arr 排序数组
     * @param p 左值
     * @param q 右值
     */
    public void quickSort_r(int[] arr,int p,int q){
        //终止条件
        if(p>=q){
            return;
        }
        int mid=position(arr,p,q);
        //右减 左增
        quickSort_r(arr,p,mid-1);
        quickSort_r(arr,mid+1,q);
    }

    private int position(int[] arr,int p,int q) {
        int r=p-1;//记录小于q元素集合 右区间（右开）
        for (int i = p; i < q; i++) {
            if(arr[i]<arr[q]){
                //交换
                swap(arr,r+1,i);
                r++;
            }
        }
        //最后交换中间元素
        swap(arr,r+1,q);
        r++;
        return r;
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr={2,1,4,0,9,7};
        System.out.println(Arrays.toString(quickSort.quickSort(arr)));
    }
}
