package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/9 11:47
 * 文件说明：
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class IsValidBST {
    private boolean flag = true;

    private Integer pre=null;

    public boolean isValidBST(TreeNode root) {
        reserve(root);
        return flag;
    }

    /**
     * 利用中序遍历的有序性
     * @param root
     */
    public void reserve(TreeNode root) {
        if (root == null) {
            return;
        }
        if(!flag){
            return;
        }
        reserve(root.left);
        if(pre!=null&&pre>root.val){
            flag=false;
        }
        //继续节点
        pre=root.val;
        reserve(root.right);
    }

    public static void main(String[] args) {
        TreeNode left4 = new TreeNode(7, null, null);
        TreeNode left3 = new TreeNode(3, null, null);

        TreeNode left2 = new TreeNode(6, null, null);
        TreeNode left1 = new TreeNode(4, null, null);
        TreeNode root = new TreeNode(5, left1, left2);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));
    }
}

