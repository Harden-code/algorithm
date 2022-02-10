package org.harden.coder.backtrace;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/22 16:58
 * 文件说明：
 * 216. 组合总和 III
 * </p>
 */
public class CombinationSum3 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) {
            return result;
        }
        backTrace(new ArrayList<>(), 0, 1, k, n,n);
        return result;
    }

    public void backTrace(List<Integer> path, int p, int index, int k,int n, int target) {

        if (p == k ) {
            if (target == 0 ) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (path.contains(i)) {
                continue;
            }
            int j = target - i;
            path.add(i);
            backTrace(path, p + 1, i, k, n,j);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum = new CombinationSum3();

        List<List<Integer>> lists = combinationSum.combinationSum3(9, 45);
        lists.forEach(System.out::println);
    }
}
