//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。 
//
// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
//相连的房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1384 👎 0

package org.harden.dp.leetcode.editor.cn;

import org.harden.tree.leetcode.editor.cn.TreeNode;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-08-03 21:51:11
 */
class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private int[] dp = {-1, -1};

        public int rob(TreeNode root) {
            dfs(root);
            return Math.max(dp[0], dp[1]);
        }


        private void dfs(TreeNode root) {
            if (root.left == null && root.right == null) {
                //0放
                return;
            }
            //放或者不放
            TreeNode left = root.left;
            int l=0;
            TreeNode right = root.right;
            int r=0;

            if (left != null) {
                dfs(left);
                l=left.val;
            }
            if (right != null) {
                dfs(right);
                r=right.val;
            }
            if (dp[0] == -1 && dp[1] == -1) {
//                dp[0] = Math.max(l,r);
                dp[0] = l+r;
                dp[1] = 0;
                System.out.println(Arrays.toString(dp)+":"+root.val);
                return;
            }
            int i = dp[0];
            int j = dp[1];

            //放 上阶段放,上阶段不放+这阶段放
            dp[0] = j + l+r;
            //不偷 上阶偷，上阶段不tou
            dp[1] = Math.max(i, j);
            System.out.println(Arrays.toString(dp)+":"+root.val);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}