package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/22 14:48
 * 文件说明：39. 组合总和 </p>
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        backTrace(new ArrayList<>(), candidates, 0, target);
        return result;
    }

    /**
     * 候选数组里有 2，如果找到了组合总和为 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
     * 同理考虑 3，如果找到了组合总和为 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下
     *
     */
    public void backTrace(List<Integer> path, int[] candidates, int start, int num) {
      if(num<=0){
          if(num==0){
              result.add(new ArrayList<>(path));
          }
          return;
      }
      for(int i=start;i<candidates.length;i++){
          int j = num - candidates[i];
          path.add(candidates[i]);
          backTrace(path,candidates,i,j);

          if(!path.isEmpty()){
              path.remove(path.size()-1);
          }


      }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] a = {2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum.combinationSum(a, 7);
        lists.forEach(System.out::println);
    }
}
