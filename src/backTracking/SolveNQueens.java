package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//按照行成为一颗二叉树
public class SolveNQueens {

    static List<List<String>> res = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(solveNQueens(3));
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars,'.');
        }
        dfs(board,n,0);
        return res;
    }
    public static void dfs(char[][] board,int n,int row){
        if(row==n){
            List<String> list = new LinkedList<>();
            for (char[] chars : board) {
                list.add(String.valueOf(chars));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!isValid(board,n,row,i)){
                continue;
            }
            board[row][i]='Q';
            dfs(board,n,row+1);

            board[row][i]='.';
        }
    }


    public static boolean isValid(char[][] board,int n,int row,int col){
        //列
        for (int i = 0; i < row; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //45度角
        for (int i = row-1,j=col+1; i >=0&&j<=n-1 ; i--,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //135度角
        for (int i = row-1,j=col-1; i >=0&&j>=0 ; i--,j--) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
