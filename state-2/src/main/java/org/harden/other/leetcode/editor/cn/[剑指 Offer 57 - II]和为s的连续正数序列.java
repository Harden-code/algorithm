//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 471 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-08-23 22:25:41
 */
class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(15);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> dump = new ArrayList<>();
            int l = 1;
            int r = 2;
            int sum = 3;
            while (l < target && r < target) {
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = l; i <= r; i++) {
                        list.add(i);
                    }
//                    System.out.println(list.toString());
                    dump.add(list);
                    sum -= l;
                    l++;
                } else if (target > sum) {
                    r++;
                    sum += r;
                } else {
                    //sum>target
                    sum -= l;
                    l++;
                }
            }
            int[][] result = new int[dump.size()][];
            for (int i = 0; i < dump.size(); i++) {
                int[] ints = new int[dump.get(i).size()];
                for (int j = 0; j < dump.get(i).size(); j++) {
                    ints[j] = dump.get(i).get(j);
                }
                result[i] = ints;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}