package org.harden.coder.backtrace;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/22 16:08
 * 文件说明： 40. 组合总和 II</p>
 */
public class CombinationSum2 {
    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            map.put(candidates[i], map.getOrDefault(candidates[i], 0) + 1);
        }
        int[] values = new int[map.size()];
        int[] counts = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            values[i] = entry.getKey();
            counts[i] = entry.getValue();
            i++;
        }
        backTrace(new ArrayList<>(), values, counts,0, target);
        return result;

    }

    public void backTrace(List<Integer> path, int[] values, int[] counts,int start, int num) {
        if (num <= 0) {
            if (num == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < values.length; i++) {

            if (counts[i] <= 0) {
                continue;
            }
            int j = num - values[i];
            path.add(values[i]);
            counts[i]--;
            backTrace(path, values, counts,i, j);
            counts[i]++;
            path.remove(path.size() - 1);
        }

    }


    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] a={10,1,2,7,6,1,5};
        combinationSum2.combinationSum2(a,8);
    }

}
