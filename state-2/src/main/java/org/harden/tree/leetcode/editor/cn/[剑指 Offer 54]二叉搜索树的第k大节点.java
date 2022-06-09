//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 306 👎 0

package org.harden.tree.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-05-26 22:03:34
 */
class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(4);
//        TreeNode treeNode2 = new TreeNode(1,null,treeNode5);
//        TreeNode treeNode1 = new TreeNode(3,treeNode2,treeNode3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2,treeNode2,null);
        System.out.println(solution.kthLargest(treeNode1, 1));
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
    private int i=0;
    private int value;
    public int kthLargest(TreeNode root, int k) {
        //按照中序遍历 找到最大的k个
        kthLargest_(root, k);
//        System.out.println(i);
        return value;
    }
    public void  kthLargest_(TreeNode root, int k) {
        if(root==null){
            return ;
        }
        if(i==k){
            return;
        }
       kthLargest_(root.right,k);
        i++;
//        System.out.println(i+"-"+root.val);
        //注意中序遍历的走向
        if(i==k){
            value=root.val;
            return;
        }
        kthLargest_(root.left,k);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}