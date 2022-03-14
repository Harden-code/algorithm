package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/18 17:24
 * 文件说明：90. 子集 II </p>
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetsWithDup {
    private List<List<Integer>> result = new ArrayList<>();


    private Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        backTrace(nums, 0, new ArrayList<>());
        return result;
    }

    public boolean containsAll(List<List<Integer>> result, List<Integer> list) {
        boolean flag = true;
        for (List<Integer> integers : result) {
            if (integers.equals(list)) {
                flag = false;
            }
        }
        return flag;
    }

    public void backTrace(int[] nums, int path, List<Integer> list) {
        if (path == nums.length) {
            if (containsAll(result, list)) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        backTrace(nums, path + 1, list);
        //相同的直接把相同区间加入
        if (path < nums.length-1 && nums[path + 1] == nums[path]) {
            int target = nums[path];
            int i=1+path;
            while (i <nums.length &&target == nums[i]) {
                list.add(nums[path]);
                i++;
            }
        } else {
            list.add(nums[path]);
        }

        backTrace(nums, path + 1, list);

        list.remove(list.size() - 1);
    }




    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        int[] a = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(a);
        System.out.println(lists);
    }
}
