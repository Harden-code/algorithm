//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1213 👎 0

package org.harden.tree.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-06-19 21:08:58
 */
class FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5,null,treeNode7);
        TreeNode treeNode3 = new TreeNode(2,treeNode5,treeNode6);
        TreeNode treeNode2 = new TreeNode(1,treeNode3,treeNode4);
        solution.flatten(treeNode2);
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
    private TreeNode h=new TreeNode();
    public void flatten(TreeNode root) {
       dfs(root);
    }

    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode l =root.left;
        root.left=null;
        TreeNode r = root.right;
        root.right=null;
        //这里root指向h
        h.right=root;
        //h=h.right相当于操作root
        //由于例子 root=2（3，4）leftRoot=3(null,null)
        h=h.right;
        dfs(l);
        dfs(r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}