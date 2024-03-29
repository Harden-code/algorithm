package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/11 14:52
 * 文件说明：
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 注意：本题相对原题稍作改动
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class ConvertBiNode {
    private TreeNode treeNode=new TreeNode(0);

    private TreeNode tail=treeNode;
    public TreeNode convertBiNode(TreeNode root) {
        iterateTree(root);
        return treeNode.right;
    }

    private TreeNode iterateTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //中序遍历
        convertBiNode(root.left);
        tail.right=root;
        root.left=null;
        tail=root;
        convertBiNode(root.right);
        return root;
    }
}
