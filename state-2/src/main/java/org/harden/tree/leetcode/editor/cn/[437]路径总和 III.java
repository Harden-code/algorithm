//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1354 👎 0

package org.harden.tree.leetcode.editor.cn;

import java.util.List;

/**
 * @author junsenfu
 * @date 2022-06-07 21:41:46
 */
class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode treeNode2 = new TreeNode(-2);
        TreeNode treeNode1 = new TreeNode(-3, treeNode2, null);
        solution.pathSum(treeNode1, -5);
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

        private int count;

        public int pathSum(TreeNode root, int targetSum) {

//            if(root.val==targetSum&&root.right==null&&root.left==null){
//                count++;
//                return 1;
//            }
            wrapper(root, targetSum);
            return count;
        }

        private void wrapper(TreeNode root, int target) {

            if (root == null) {
                return;
            }
//            if (root.val == target) {
//                count++;
//            }
            dfs(root, 0, target);
            wrapper(root.left, target);
            wrapper(root.right, target);
        }

        private void dfs(TreeNode root, int sum, int target) {
            //存在负数不用判断 sum>target情况
            //这样判断会少一层
            if (root.left == null && root.right == null) {
                //底为target特殊情况 因为遍历wrapper是以节点遍历从上到下
                if ((sum + root.val) == target) {
                    count++;
                }
                return;
            }
            //上一个sum+root.val
            if (sum+root.val == target) {
                count++;
            }
            if (root.left != null) {
                dfs(root.left, sum + root.val, target);
            }
            if (root.right != null) {
                dfs(root.right, sum + root.val, target);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}