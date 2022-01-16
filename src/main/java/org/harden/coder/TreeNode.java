package org.harden.coder;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:22
 * 文件说明： </p>
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
