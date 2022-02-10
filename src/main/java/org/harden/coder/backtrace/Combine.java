package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/18 9:58
 * 文件说明：77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </p>
 */
public class Combine {
    private List<List<Integer>> result=new ArrayList<>();
    /**
     * n->k 范围，k组合个数
     */
    public List<List<Integer>> combine(int n, int k) {
        if(n<1){
            return result;
        }
        int[] ints=new int[n];
        for(int i=0;i<n;i++){
            ints[i]=i+1;
        }
        //需要加2次
        backTrance(ints,0,k,0,new ArrayList<>());
        return result;
    }

    /**
     * @param n 遍历数组
     * @param k 移动下标
     * @param end 结束条件
     * @param j 递归循环起始位置
     * @param list 存放路径
     */
    public void backTrance(int[] n,int k,int end,int j,List<Integer> list){
        //递归枚举终止条件,也就是到了最后一位k
        if(k==end){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=j;i<n.length;i++){
            if(list.contains(n[i])){
                continue;
            }
            //加入结果路径
            list.add(n[i]);
            backTrance(n,k+1,end,i,list);
            //删除最后一位
            list.remove(list.size()-1);
        }
    }


    public boolean containsAll(List<List<Integer>> result,List<Integer> list){
        boolean flag = true;
        for (List<Integer> integers : result) {
            if (integers.containsAll(list)) {
                flag =false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4,2);
    }
}
