//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 341 👎 0

package org.harden.tree.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  junsenfu
 * @date 2022-06-06 21:20:35
 */
class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null){
            return result;
        }
        //通过在树上回溯（遍历所以节点进行计算）注意递归终止条件
        List<Integer> path = new ArrayList<>();

        dfs(root,path,0,target);
        return result;
    }

    private void dfs(TreeNode root,List<Integer> path,int pathSum,int target){
        //该节点是终止节点
        if(root.right==null&&root.left==null){
            if(target==(pathSum+root.val)){
                //5 4 11 +2
                path.add(root.val);
                List<Integer> dump=new ArrayList<>(path);
                result.add(dump);
                //remove
                path.remove(path.size()-1);
            }
            //路径回退 特殊情况
            if(!path.isEmpty()){
                //remove 11 退到上个节点 递归还会在进去
                path.remove(path.size()-1);
            }
            return;
        }

        if(root.left!=null){
            path.add(root.val);
            dfs(root.left,path,pathSum+root.val,target);
        }
        if(root.right!=null){
            path.add(root.val);
            dfs(root.right,path,pathSum+root.val,target);
        }
        if (!path.isEmpty()){
            path.remove(path.size()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}