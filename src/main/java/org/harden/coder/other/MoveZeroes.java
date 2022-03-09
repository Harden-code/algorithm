package org.harden.coder.other;

/**
 * 283. 移动零
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int p=0;
        //不为0的
        int q=-1;
        while (p<=nums.length-1){
            if(nums[p]!=0){
                swap(p,q+1,nums);
                q++;
            }
            p++;
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums={0,1,0,3,12};
        moveZeroes.moveZeroes(nums);
    }
}
