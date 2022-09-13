package org.harden.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/5 9:30
 * 文件说明： </p>
 */
public class FindDuplicateSubtrees {

    private Map<String,Integer> map=new HashMap<>();
    private List<TreeNode> result=new ArrayList<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        return result;
    }

    private String dfs(TreeNode root){
        //后序遍历
        if(root==null){
            //必须空格  不是返回会相同
            return " ";
        }
        StringBuilder builder = new StringBuilder();
        //每个节点递归下去
        builder.append(root.val);
        builder.append("-");
        builder.append(dfs(root.left));
        //去掉 子节点相同
//        builder.append("-");
        builder.append(dfs(root.right));
        String key = builder.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) result.add(root);


        return builder.toString();
    }



    private Set<TreeNode> result_ = new HashSet<>();


    //出现重复现象 如果左右梁底都相同
    public List<TreeNode> findDuplicateSubtrees_(TreeNode root) {
        dfs_(root.left, root.right);
        List<TreeNode> dump = new ArrayList<>();
        for (TreeNode treeNode : result) {
            dump.add(treeNode);
        }
        return dump;
    }

    private void dfs_(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null || rightRoot == null) {
            return;
        }
        if (is(leftRoot, rightRoot)) {
            result.add(leftRoot);
        }
//        if(leftRoot.left!=null&&rightRoot.left!=null){
//            if(leftRoot.left.val==rightRoot.left.val){
        dfs_(leftRoot.left, rightRoot.left);
//            }
//            if(leftRoot.left.val==rightRoot.val){
        dfs_(leftRoot.left, rightRoot);
//            }
//            if(leftRoot.val==rightRoot.left.val){
        dfs_(leftRoot, rightRoot.left);
//            }

//        }
//        if(leftRoot.right!=null&&rightRoot.right!=null){
//            if(leftRoot.right.val==rightRoot.right.val){
        dfs_(leftRoot.right, rightRoot.right);
//            }
//            if(leftRoot.val==rightRoot.right.val){
        dfs_(leftRoot, rightRoot.right);
//            }
//            if(leftRoot.right.val==rightRoot.val){
        dfs_(leftRoot.right, rightRoot);
//            }
//        }
    }

    private boolean is(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        if (leftRoot.val != rightRoot.val) {
            return false;
        }
        return is(leftRoot.left, rightRoot.left) && is(leftRoot.right, rightRoot.right);
    }
}
