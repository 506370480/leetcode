package dp;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{9,1,4,8}}));
    }
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i],-1);
        }

        dp[0][0]=grid[0][0];
        dp(dp,grid,grid.length-1,grid[0].length-1);
        return dp[grid.length-1][grid[0].length-1];
    }
    public static int dp(int[][] dp,int[][] grid,int row, int col){
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(row==0||col==0){
            if(row==0){
                dp[row][col] =  dp(dp,grid,row,col-1)+grid[row][col];
            }else{
                dp[row][col] = dp(dp,grid,row-1,col)+grid[row][col];
            }
        }else{
            dp[row][col]=Math.min(dp(dp,grid,row-1,col),dp(dp,grid,row,col-1))+grid[row][col];
        }
        return dp[row][col];
    }

}
