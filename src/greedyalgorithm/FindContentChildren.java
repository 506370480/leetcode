package greedyalgorithm;

import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1,1}));
    }

    //动态规划
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int[][] dp = new int[g.length+1][s.length+1];
        
        //注意，可以使用一个for和一个while来实现这个操作
        for (int i = 0,j=0; i <g.length&&j<s.length ; i++,j++) {
            while (j<s.length&&g[i]>s[j]){
                j++;
            }
            if(j<s.length){
                count++;
            }
        }
        return count;

        //下边是自己尝试写的dp算法的步骤，但是失败了
//        for (int i = 1,j=1; i <= g.length&&j<=s.length;i++,j++) {
//            if(s[j-1]>=g[i-1]){
//                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-1])+1;
//                continue;
//            }else{
//                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-1]);
//                j++;
//            }
//        }
//        return dp[g.length][s.length];
    }
}
