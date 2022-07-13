//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 👍 111 👎 0

package org.harden.tree.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-06-19 21:49:24
 */
class BinodeLcci{
    public static void main(String[] args) {
        Solution solution = new BinodeLcci().new Solution();
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5,null,treeNode7);
        TreeNode treeNode3 = new TreeNode(2,treeNode5,treeNode6);
        TreeNode treeNode2 = new TreeNode(1,treeNode3,treeNode4);
        solution.convertBiNode(treeNode2);
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode h=new TreeNode();
    private TreeNode tail=h;
    public TreeNode convertBiNode(TreeNode root) {
        //把二叉搜索树转换为单向链
        dfs(root);
        return h.right;
    }

    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        TreeNode rigth=root.right;
        //注意把节点左右子节点去掉
        root.left=null;
        root.right=null;
        tail.right=root;
        tail=tail.right;
        dfs(rigth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}