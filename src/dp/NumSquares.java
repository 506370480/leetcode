package dp;

import java.util.Arrays;

public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        if(n>1){
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            if(Math.sqrt(i)==(int)Math.sqrt(i)){
                dp[i]=1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                min = min>(dp[i-j]+dp[j])?((dp[i-j]+dp[j])):min;
            }
            dp[i]=min;
        }
        return dp[n];
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        if(n>1){
            dp[2] = 2;
        }
        dp(dp,n);
        return dp[n];
    }
    public static int dp(int[] dp,int n){
        if(dp[n]!=-1){
            return dp[n];
        }
        if(Math.sqrt(n)==(int)Math.sqrt(n)){
            dp[n] = 1;
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i =(int)Math.sqrt(n/3); i <=(int)Math.sqrt(n) ; i++) {
            min = min>(dp(dp,n-i*i)+dp(dp,i*i))?(dp(dp,n-i*i)+dp(dp,i*i)):min;
        }
        dp[n] = min;
        return min;
    }
}
