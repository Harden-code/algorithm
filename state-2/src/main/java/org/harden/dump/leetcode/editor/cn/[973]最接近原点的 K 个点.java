//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最
//近的 k 个点。 
//
// 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)² + (y1 - y2)² ）。 
//
// 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[1,3],[-2,2]], k = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,3],[5,-1],[-2,4]], k = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= points.length <= 10⁴ 
// -10⁴ < xi, yi < 10⁴ 
// 
// Related Topics 几何 数组 数学 分治 快速选择 排序 堆（优先队列） 👍 343 👎 0

package org.harden.dump.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author junsenfu
 * @date 2022-06-23 20:57:01
 */
class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
        int[][] ints = {{3, 3}, {5, -1}, {-2, 4}};
        solution.kClosest(ints, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            //找最小的
            //大顶堆   t1[0] * t1[0] + t1[1] * t1[1] - t2[0] * t2[0] + t2[1] * t2[1]
            PriorityQueue<int[]> dump = new PriorityQueue<>((t1, t2) -> cal(t2) - cal(t1));
            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                if (dump.size() < k) {
                    dump.add(point);
                } else {
                    int[] peek = dump.peek();
                    //大于t出来
                    if (cal(peek) > cal(point)) {
                        dump.poll();
                        dump.add(point);
                    }
                    if (cal(peek) == cal(point)&&!isSame(point,peek)) {
                        dump.add(point);
                    }
                }
            }
            int[][] result = new int[dump.size()][];
            int i = 0;
            while (!dump.isEmpty()) {
                result[i++] = dump.poll();
            }
            return result;
        }

        private int cal(int[] ints) {
            return ints[0] * ints[0] + ints[1] * ints[1];
        }

        private boolean isSame(int[] t1,int[] t2){
            return t1[0]==t2[0]&&t1[1]==t2[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}