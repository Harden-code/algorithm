//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1337 👎 0

package org.harden.dfs.leetcode.editor.cn;

import java.util.*;

/**
 * @author junsenfu
 * @date 2022-07-14 21:09:50
 */
class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        int[][] image = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        solution.canFinish(5, image);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> count = new HashMap<>();

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            //使用队列 记录为0的元素
            Set[] graph = initGraph(prerequisites, numCourses);
            while (!count.isEmpty()) {
                int zero = findZero();

                if (zero != -1) {
                    for (int i = 0; i < graph.length; i++) {
                        Set list = graph[i];
                        if (list.contains(zero)) {
                            list.remove(zero);
                            Integer k = count.get(i);
                            k--;
                            count.put(i, k);
//                            if (k == 0) {
//                                //不能删除 否则就跳过元素
////                                count.remove(i);
//                            } else {
//
//                            }

                        }
                    }
                    //删除等于0的节点
                    count.remove(zero);
                } else {
                    return false;
                }
            }
            return true;
        }

        private int findZero() {
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                Integer value = entry.getValue();
                if (value == 0) {
                    return entry.getKey();
                }
            }
            return -1;
        }

        private Set[] initGraph(int[][] prerequisites, int numCourses) {
            Set[] graph = new HashSet[numCourses];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new HashSet();
                count.put(i, 0);
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int key = prerequisites[i][0];
                int value = prerequisites[i][1];
                count.put(key, count.getOrDefault(key, 0) + 1);
                graph[key].add(value);
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}