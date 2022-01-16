package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/15 23:24
 * 文件说明： 124. 二叉树中的最大路径和</p>
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        add(root);
        return max;
    }

    /**
     * 转换->求每个节点为上端点的最大路劲
     * 如果子节点有负数 就直接过
     * @param root
     * @return
     */
    public int add(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //返回左 右 子树的边和
        int left = add(root.left);
        int right = add(root.right);
        System.out.println(left + " " + right);

        //求左右子树为整数
        int r = root.val;
        if(left>0){
            r=left+r;
        }
        if(right>0){
            r=right+r;
        }
        max=Math.max(r,max);
        //计算 左右的累加值
        int res=root.val;
        //分开计算 返回最大的  去除负数情况。
        if(root.val+left>res){
            res=root.val+left;
        }
        if(root.val+right>res){
            res=root.val+right;
        }
        return res;

    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(2, node1, node3);

        TreeNode node5 = new TreeNode(-2);
        TreeNode node4 = new TreeNode(2, node1, node5);

        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(node4));

    }
}
