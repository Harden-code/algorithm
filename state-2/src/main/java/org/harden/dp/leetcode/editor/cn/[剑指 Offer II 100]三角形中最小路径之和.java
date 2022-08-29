//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// 
//
// 注意：本题与主站 120 题相同： https://leetcode-cn.com/problems/triangle/ 
// Related Topics 数组 动态规划 👍 18 👎 0

package org.harden.dp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author junsenfu
 * @date 2022-07-30 21:40:50
 */
class IlPe0q {
    public static void main(String[] args) {
        Solution solution = new IlPe0q().new Solution();
        List<List<Integer>> path = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        list1.add(2);
//        list1.add(-1);
        path.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
//        list2.add(3);
//        list2.add(2);
        path.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);


//        list3.add(-3);
//        list3.add(1);
//        list3.add(-1);
        path.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        path.add(list4);

        solution.minimumTotal(path);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {

            int len = triangle.get(triangle.size() - 1).size();
            int[][] dp = new int[len][len];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][0] = triangle.get(0).get(0);
            //dp[i][j]=min(dp[i-1][j] dp[i-1][j-1] dp[i-1][j+1])+value
            //特殊情况 j=0=>dp[i-1][j]:dp[i-1][j-1]
            // j=dp[i-1].len=>dp[i-1][j-1]:dp[i-1][j]
            for (int i = 1; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int left, right = Integer.MAX_VALUE;
                    if (j == 0) {
                        left = dp[i - 1][j];
                    } else {
                        left = dp[i - 1][j - 1];
                    }

                    if (j == triangle.get(i - 1).size()) {
                        right = dp[i - 1][j - 1];

                    } else {
                        right = dp[i - 1][j];
                    }
                    dp[i][j] = Math.min(left, right) + triangle.get(i).get(j);
                }
            }
//            print(dp);
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < dp[len - 1].length; i++) {
                result = Math.min(dp[len - 1][i], result);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}