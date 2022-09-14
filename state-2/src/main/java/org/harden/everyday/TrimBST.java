package org.harden.everyday;


import java.util.ArrayList;
import java.util.List;

/**
 * 669. 修剪二叉搜索树
 */
public class TrimBST {


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if (left != null && (left.val < low || left.val > high)) {
            left = null;
        }
        if (right != null && (right.val < low || right.val > high)) {
            right = null;
        }
        //因为是二叉搜索数 通过区间判断
        if(root.val < low  ){
            return right;
        }
        if(root.val > high){
            return left;
        }
        root.left = left;
        root.right = right;
        return root;
    }

    private List<Integer> delData = new ArrayList<>();

    private TreeNode thisRoot;

    public TreeNode trimBST_(TreeNode root, int low, int high) {
        //二叉搜索数删除
        dfs_find(root, low, high);
        this.thisRoot = root;
        for (int i = 0; i < delData.size(); i++) {
            del(delData.get(i));
        }
        return thisRoot;
    }

    private void dfs_find(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val < low || root.val > high) {
            delData.add(root.val);
        }
        dfs_find(root.left, low, high);
        dfs_find(root.right, low, high);
    }

    /**
     * 标准二叉树删除
     * 1 删除节点没有子节点 直接设置为空
     * 2 删除节点有一个子节点 删除节点的父亲节点指向删除节点的子节点
     * 3 删除节点有两个子节点 先找到待删除的节点，然在在待删除节点的右子数找到最小的 进行交换
     *
     * @param data
     */
    private void del(int data) {
        TreeNode p = this.thisRoot;//记录当前节点
        TreeNode pp = null;//记录当前节点的父节点
        while (p != null && p.val != data) {
            pp = p;
            if (p.val > data) {
                p = p.left;
            } else {
//                root.val<data
                p = p.right;
            }
        }
        //未找到对应的节点
        if (p == null) {
            return;
        }

        //判断删除节点子节点是否有两个
        if (p.left != null && p.right != null) {
            TreeNode min = p.right;
            TreeNode minP = p;
            //找到这个节点右子树最小节点，交换位置
            while (min.left != null) {
                minP = min;
                min = min.left;
            }
            p.val = min.val;
            p = min;
            pp = minP;
        }
        TreeNode child;
        //在删除节点
        //case1 删除节点只有一个子节点 case2 没有子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        if (pp == null) {
            //pp为null 头节点
            this.thisRoot = child;
        } else if (pp.right == p) {
            pp.right = child;
        } else {
            pp.left = child;
        }

    }
}
