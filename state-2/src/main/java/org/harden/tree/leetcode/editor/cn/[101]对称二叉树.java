//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1927 👎 0

package org.harden.tree.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-05-24 22:16:48
 */
class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(2,treeNode7,treeNode6);
//        TreeNode treeNode2 = new TreeNode(2,treeNode4,treeNode5);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1,treeNode2,treeNode3);
        solution.isSymmetric(treeNode1);
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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric_r(root.left,root.right);
    }
    public boolean isSymmetric_r(TreeNode left,TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left!=null&&right!=null){
            if(left.val!= right.val){
                return false;
            }else {
                return isSymmetric_r(left.left,right.right)&&isSymmetric_r(left.right,right.left);
            }
        }else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}