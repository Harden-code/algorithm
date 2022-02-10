package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/18 17:25
 * 文件说明： 46. 全排列
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </p>
 */
public class Permute {
    private List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return result;
        }
        backTrace(nums,0,new ArrayList<>());
        return result;
    }

    public void backTrace(int[] nums,int k,List<Integer> list){
        if(k==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrace(nums,k+1,list);
            list.remove(list.size()-1);
        }
    }
}
