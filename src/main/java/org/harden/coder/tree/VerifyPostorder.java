package org.harden.coder.tree;

import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/13 12:52
 * 文件说明：剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * </p>
 */
public class VerifyPostorder {
    private boolean flag = true;

    public boolean verifyPostorder(int[] postorder) {
        return reserve(postorder, 0, postorder.length - 1);
    }

    /**
     * 子问题->比较左右节点或者父节点的大小
     * 后续遍历，头节点在尾部
     * 左子树->遍历数组找到第一个大于父节点的就是 左子树
     * 右子树->左子树的l->头节点
     */
    public boolean reserve(int[] postorder, int p, int q) {
        if (p >= q) {
            return true;
        }
        int root = postorder[q];
        int l = p;
        //分离左子树，已经确认了 右边的节点比左边的大
        while (l < q && postorder[l] < root) {
            l++;
        }
        int k=l;
        //判断 右子树
        while (k<q){
            if(postorder[k]<postorder[q]){
                return false;
            }
            k++;
        }
        boolean left= reserve(postorder, p, l - 1);
        if(!left){return false;}
        boolean right=reserve(postorder,l,q-1);
        return right;
    }


    public static void main(String[] args) {
        int[] a = {1, 6, 3, 2, 5};
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        System.out.println(verifyPostorder.verifyPostorder(a));
    }


}
