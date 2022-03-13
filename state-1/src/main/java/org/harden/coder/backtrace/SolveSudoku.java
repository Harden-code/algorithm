package org.harden.coder.backtrace;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/19 23:11
 * 文件说明： </p>
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        int n=board.length;
        backTrance(board,0,n);
    }
    public void backTrance(char[][] board,int row,int n){
        if(row==n){
            return;
        }
        //不是点继续走
        if(board[row][n]!='.'){
            backTrance(board,row,n+1);
        }else {
            
        }

    }
}
