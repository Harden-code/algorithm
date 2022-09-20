package org.harden.everyday;

import java.nio.file.Paths;
import java.util.Random;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/2 11:31
 * 文件说明：687. 最长同值路径 </p>
 */
public class LongestUnivaluePath {
    private int result;

    //求边数
    public int longestUnivaluePath(TreeNode root) {
        int[] dfs = dfs(root);

        return result;
    }

    private int[] dfs(TreeNode root) {
        //int[0]root节点 int[1]相同元素个数
        if (root == null) {
            return new int[]{-1001, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //左边和root
        int l = 0;
        //右边边和root
        int r = 0;
        if (left[0] == root.val) {
            l = left[1] + 1;
        }
        if (right[0] == root.val) {
            r = right[1] + 1;
        }
        int p = Math.max(l, r);
        //root=left=right 就链接起来
        if (right[0] == root.val && left[0] == root.val) {
            int sum= l + r;
            result = Math.max(result,sum);
        } else {
            //选择左右单边最大的
            result = Math.max(p, result);
        }
        return new int[]{root.val, p};
    }
}
