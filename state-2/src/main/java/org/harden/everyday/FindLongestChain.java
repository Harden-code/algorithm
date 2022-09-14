package org.harden.everyday;

import java.util.Arrays;
import java.util.Stack;

public class FindLongestChain {

    public static int findLongestChain(int[][] pairs) {
        int result=0;
        //基数排序最后一位
        //排第一位条件很多
        Arrays.sort(pairs,(x,y)->x[1]-y[1]);
        //分两次
        //[a,b][c,d] b<c
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
           if(stack.isEmpty()){
               stack.push(i);
               continue;
           }
           if(pairs[stack.peek()][1]<pairs[i][0]){
               stack.push(i);
           }
        }
        //全递增
        return stack.size();
    }

    public static void main(String[] args) {
        int[][] pairs={{1,2},{7,8},{4,5}};
//        int[][] a={{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        int[][] b={{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
//        int[][] c={{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
        findLongestChain(b);
    }
}
