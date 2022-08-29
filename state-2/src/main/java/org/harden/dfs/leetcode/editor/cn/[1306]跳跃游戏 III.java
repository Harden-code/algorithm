//这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - 
//arr[i]。 
//
// 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。 
//
// 注意，不管是什么情况下，你都无法跳到数组之外。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,3,0,3,1,2], start = 5
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案： 
//下标 5 -> 下标 4 -> 下标 1 -> 下标 3 
//下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3 
// 
//
// 示例 2： 
//
// 输入：arr = [4,2,3,0,3,1,2], start = 0
//输出：true 
//解释：
//到达值为 0 的下标 3 有以下可能方案： 
//下标 0 -> 下标 4 -> 下标 1 -> 下标 3
// 
//
// 示例 3： 
//
// 输入：arr = [3,0,2,1,2], start = 2
//输出：false
//解释：无法到达值为 0 的下标 1 处。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 5 * 10^4 
// 0 <= arr[i] < arr.length 
// 0 <= start < arr.length 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 👍 120 👎 0

package org.harden.dfs.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-07-18 21:16:58
 */
class JumpGameIii {
    public static void main(String[] args) {
        Solution solution = new JumpGameIii().new Solution();
        int[] arr={4,2,3,0,3,1,2};
        solution.canReach(arr,5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean result = false;
        private int[] dic = {1, -1};
        private boolean[] visited;

        public boolean canReach(int[] arr, int start) {
            visited = new boolean[arr.length];
            //dfs 找到为0的元素
            dfs(arr, start);
            return result;
        }

        private void dfs(int[] arr, int index) {
            visited[index] = true;
            if (arr[index] == 0) {
                result = true;
                return;
            }
            for (int i = 0; i < dic.length; i++) {
                int next_index = index + dic[i] * arr[index];
                if (next_index < 0 || next_index >= arr.length || visited[next_index]) {
                    continue;
                }
                dfs(arr, next_index);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}