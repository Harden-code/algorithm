package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/16 14:23
 * 文件说明： 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 *
 * </p>
 */
public class PathSum {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return results;
        }
        dfs(root,list,target,target);
        return results;
    }

    /**
     *
     * @param root 节点
     * @param result 结果
     * @param sum 相加值
     * @param target 目标值
     */
    public void dfs(TreeNode root, List<Integer> result, int sum, int target) {
        //到节点后，需要弹出元素
        result.add(root.val);
        //这是到尾节点的情况，如果按照前序遍历去遍历，会出现两次出栈
        if(root.right==null&&root.left==null){
            //找到路劲情况，
            if(sum-root.val==0){
                List<Integer> list=new ArrayList<>(result);
                results.add(list);
            }
            //删除根节点
            result.remove(result.size()-1);
            return;
        }
        if(root.left!=null){
            dfs(root.left,result,sum- root.val,target);
        }
        if(root.right!=null){
            dfs(root.right,result,sum- root.val,target);
        }
        //不是根节点的情况
        result.remove(result.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2, node2, node5);
        PathSum pathSum = new PathSum();
        pathSum.pathSum(node4,6);
    }

}
