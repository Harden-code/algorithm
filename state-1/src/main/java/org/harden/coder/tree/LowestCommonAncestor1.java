package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/12 12:52
 * 文件说明：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class LowestCommonAncestor1 {

    private TreeNode node = null;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //查找节点左右树包含p q
        findRoot(root, p, q);
        return node;
    }

    public int findRoot(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }

        int l = findRoot(root.left, p, q);
        //结束条件
        if(node!=null){
            return 2;
        }
        int r = findRoot(root.right, p, q);
        if(node!=null){
            return 2;
        }
        int temp = 0;
        //记录节点
        if (root == p || root == q) {
            temp = 1;
        }

        if (temp == 1 && (l == 1 || r == 1)) {
            node = root;
        }
        if (temp == 0 && l == 1 && r == 1) {
            node = root;
        }
        //递会总的数量
        temp = temp + l + r;
        return temp;
    }
}
