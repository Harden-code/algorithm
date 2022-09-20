package org.harden.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/20 15:12
 * 文件说明：698. 划分为k个相等的子集 </p>
 */
public class CanPartitionKSubsets {
 

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //不能拆开
        if (sum % k != 0) {
            return false;
        }
        int v=sum/k;
        Arrays.sort(nums);
        visited=new boolean[nums.length];
        back(nums,v,new ArrayList<>(),0);
        return k<=count;
    }

//    private List<List<Integer>> lists = new ArrayList<>();
    private int count;

    private int sum_path=0;

    private boolean[] visited;

    private void back(int[] nums, int target, List<Integer> path, int k) {
        if (sum_path >= target) {
            if(sum_path==target){
                for (int i = 0; i < path.size(); i++) {
                    visited[path.get(i)]=true;
                }
                count++;
            }
            return;
        }
        for (int i = k; i < nums.length; i++) {
            int val =nums[i];
            if (val+sum_path <= target&&!visited[i]) {
                sum_path+=val;
//                path.add(val);
                path.add(i);
                back(nums,target,path,i+1);
                int dif=path.get(path.size()-1);
                path.remove(path.size()-1);
                sum_path-=nums[dif];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1={4,3,2,3,5,2,1};//4
        int[] nums={2,2,2,2,3,4,5};//4
        int[] nums2={10,12,1,2,10,7,5,19,13,1};
        CanPartitionKSubsets subsets = new CanPartitionKSubsets();
        subsets.canPartitionKSubsets(nums,4);
    }
}
