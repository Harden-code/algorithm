package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/18 13:25
 * 文件说明： 78. 子集
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </p>
 */
public class Subsets {
    private List<List<Integer>> result=new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return result;
        }
        backTrace(nums,0,new ArrayList<>());
        return result;
    }
    /**
     * 加和不加的情况 进行处理
     * k 递归终止深度
     * j 用来控制循环去重
     */
    public void backTrace(int[] nums,int k,List<Integer> list){

        if(nums.length==k){
            result.add(new ArrayList<>(list));
            return;
        }

        //不做处理 // 下滑排除数组
        backTrace(nums,k+1,list);
        //做处理
        list.add(nums[k]);
        backTrace(nums,k+1,list);
        list.remove(list.size()-1);

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] a={1,2,3};
        subsets.subsets(a);
    }
}
