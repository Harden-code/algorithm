package org.harden.everyday;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/8/30 11:35
 * 文件说明：</p>
 */
public class ConstructMaximumBinaryTree {
    //654. 最大二叉树
    //创建一个根节点，其值为 nums 中的最大值。
    //递归地在最大值 左边 的 子数组前缀上 构建左子树。
    //递归地在最大值 右边 的 子数组后缀上 构建右子树。
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int index = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        TreeNode left = dfs(nums, l, index - 1);
        TreeNode right = dfs(nums, index + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }

    private int findMax(int[] nums, int l, int r) {
        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        //返回下标
        return index;
    }

    //998. 最大二叉树 II
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        int[] arr = merger(root);
        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, temp.length - 1);
        temp[temp.length - 1] = val;
        System.out.println(Arrays.toString(arr));
        final TreeNode dfs = dfs(temp, 0, temp.length - 1);
        return dfs;
    }

    public int[] merger(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int[] left = merger(root.left);
        int[] right = merger(root.right);
        //+1 是加root节点
        int[] arr = new int[left.length + right.length + 1];
        merger_arr(arr, left, right, root.val);
        return arr;
    }

    public void merger_arr(int[] arr, int[] left, int[] right, int val) {
        int i = 0;
        while (i < left.length) {
            arr[i] = left[i];
            i++;
        }
        arr[i++] = val;
        while (i < arr.length) {
            arr[i] = right[i - left.length - 1];
            i++;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}