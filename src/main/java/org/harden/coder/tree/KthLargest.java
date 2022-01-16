package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/9 11:54
 * 文件说明： 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * </p>
 */
public class KthLargest {
    private int num = -1;
    //记录底数

    private int count=0;

    /**
     * 找最右边 ，中序遍历
     */
    public int kthLargest(TreeNode root, int k) {
         reserve(root, k);
         return num;
    }

    public void reserve(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == count) {
            return ;
        }
        reserve(root.right, k);
        count++;
        if(count==k){
            num=root.val;
        }
        reserve(root.left, k);
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(7, null, null);
        TreeNode left3 = new TreeNode(1, null, null);
        TreeNode left1 = new TreeNode(5, null, left2);
        TreeNode root = new TreeNode(3, left3, left1);

        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.kthLargest(root, 2));
    }
}
