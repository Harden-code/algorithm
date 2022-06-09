//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-tree/ 
// Related Topics 树 深度优先搜索 二叉树 👍 448 👎 0

package org.harden.tree.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-06-05 21:31:45
 */
class ErChaShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
        TreeNode root1=new TreeNode(2);
        TreeNode root=new TreeNode(1,root1,null);
        solution.lowestCommonAncestor(root,root1,root);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private TreeNode node;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 进行转换
            // 找一个节点 这个节点包含p q的个数
            // count=left+right+val(当前节点就包含p q)
            dfs(root, p, q);
            return node;
        }

        private int dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return 0;
            }
            int val = 0;
            //当前节点就包含 p q
            if (root == q || root == p) {
                val = 1;
            }
            if(node!=null){
                return 2;
            }
            int left = dfs(root.left, p, q);
            if(node!=null){
                return 2;
            }
            int right = dfs(root.right, p, q);
            int count = val + left + right;
            if (node == null && val == 1 && (left == 1 || right == 1)) {
                node = root;
            }
            if (node == null && val == 0 && left == 1 && right == 1) {
                node = root;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}