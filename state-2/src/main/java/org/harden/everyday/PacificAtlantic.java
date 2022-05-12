package org.harden.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/4/27 17:48
 * 文件说明：417. 太平洋大西洋水流问题 </p>
 */
public class PacificAtlantic {
    //上下左右
    private int[][] dic={{1,0},{-1,0},{0,-1},{0,1}};

    private int[][] visit;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                visit=new int[heights.length][heights[0].length];
                if(dfs(heights,i,j,heights[i][j])){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        //找当前单元格 小于等于
        return result;
    }

    //当前点所有都小于或等于 当前单元格的高度
    private boolean dfs(int[][] height,int i,int j,int q){
        
        for (int k = 0; k < dic.length; k++) {
            int newI=i+dic[k][0];
            int newJ=j+dic[k][1];
            //越界 长宽高
            if(newI<0||newJ<0||
                    newI>=height.length||newJ>=height[0].length){
                continue;
            }
            if(height[newI][newJ]<q){
                return false;
            }
        }
        return true;
    }

}
