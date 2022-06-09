//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1253 👎 0

package org.harden.tree.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-05-24 21:20:55
 */
class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        //存在子问题可以直接返回
        if(root==null){
            return 0;
        }
        //规模更小的问题跟规模更大的问题解决思路相同
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        //利用子问题的解可以组合原问题的解
        int max=Math.max(left,right);
        return max+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}