//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1448 👎 0

package org.harden.sort.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author junsenfu
 * @date 2022-04-26 21:33:28
 */
class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]
        //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        public int[][] merge(int[][] intervals) {
            Stack<int[]> stack = new Stack<>();
            //基数排序 按照第一个元素排序,然后在合并区间
            sort(intervals);
            for (int i = 0; i < intervals.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(intervals[i]);
                    continue;
                }
                int[] peek = stack.peek();
                if(peek[1]>=intervals[i][0]){
                    int[] pop = stack.pop();
                    int temp=Math.max(pop[1],intervals[i][1]);
                    int[] ele=new int[]{pop[0],temp};
                    stack.push(ele);
                }else {
                    stack.push(intervals[i]);
                }

            }
            int[][] result = new int[stack.size()][];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }

        public void sort(int[][] intervals){
            for (int i = 1; i < intervals.length; i++) {
                int j=i-1;
                int[] value=intervals[i];
                for (;j>=0;j--){
                    if(value[0]<intervals[j][0]){
                        //移动
                        swap(intervals,j,j+1);
                    }else {
                        break;
                    }
                }
            }
        }

        private void swap(int[][] ints,int i,int j){
            int[] temp=ints[i];
            ints[i]=ints[j];
            ints[j]=temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}