package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/5 23:32
 * 文件说明： 104. 二叉树的最大深度
 * 定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *    返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        //去掉重复的
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    int deep=0;
    public int maxDepth1(TreeNode root) {
        reverse(root,0);
        return deep;
    }

    public void reverse(TreeNode root,int k){
        if(root==null){
            return;
        }
        k++;
        reverse(root.left,k);
        reverse(root.right,k);
        if(k>deep){
            deep=k;
        }
    }
}
