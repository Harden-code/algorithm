//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 1061 👎 0

package org.harden.tree.leetcode.editor.cn;



/**
 * @author  junsenfu
 * @date 2022-06-05 21:57:50
 */
class DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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
    private int max=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        //求左右子树的高度
        if(root==null){
            return 0;
        }
//        int left = height(root.left);
//        int right = height(root.right);
//        max=Math.max(left+right,max);
//        diameterOfBinaryTree(root.left);
//        diameterOfBinaryTree(root.right);

        dfs(root);
        return max;
    }

    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }

    private int dfs(TreeNode root){
        if(root==null)return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        //子问题 比较两个left+right的最大值
        max= Math.max(right+left,max);
        return Math.max(left,right)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}