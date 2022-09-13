package org.harden.everyday;

//1582. 二进制矩阵中的特殊位置
public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int result=0;
        //现对行列里存在的1进行统计
        //行
        int[] col=new int[mat[0].length];
        //列
        int[] row=new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==1){
                    col[j]+=1;
                    row[i]+=1;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==1&&row[i]==1&&col[j]==1){
                    result++;
                }
            }
        }
        return result;
    }
}
