package org.harden.sort.example;



import java.util.Arrays;

public class InsertSort {
    public static void inertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int j=i-1;
            int val=nums[i];
            for (; j >=0 ; j--) {
                if(nums[j]>val){
                    //移动
//                    swap(nums,j,j+1); //每次都要交换
                    nums[j+1]=nums[j];
                }else{
                    break;
                }
            }
            //0 -1
            nums[j+1]=val;
        }
    }

    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={-1,5,1,6,4,0,7,1,0,2,1,3,2};
        InsertSort.inertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
