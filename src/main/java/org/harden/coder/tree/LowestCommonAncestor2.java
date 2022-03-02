package org.harden.coder.tree;

import org.harden.coder.TreeNode;


/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/12 21:36
 * 文件说明：
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class LowestCommonAncestor2 {

    private TreeNode temp=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return temp;
    }

    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return 0;
        }
        int l=dfs(root.left,p,q);
        int r=dfs(root.right,p,q);
        int num=0;
        if(root==p||root==q){
            num=1;
        }
        if(num==1&&(l==1||r==1)){
            temp=root;
        }
        if(num==0&&(l==1&&r==1)){
            temp=root;
        }


        return num+l+r;

    }
}
