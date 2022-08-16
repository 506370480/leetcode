package dp;

import java.util.Arrays;

public class Change {
    static int[] memo;
    public static void main(String[] args) {
        System.out.println(coinChange1(new int[]{2}, 3));
    }

    //1.递归解法
    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2);
        int result = dp(coins, amount);
        return result;
    }
    public static int dp(int[] coins, int amount){
        if(amount==1) return 1;
        if(amount<1) return -1;
        if(memo[amount]!=-2){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int subProblem = dp(coins, amount - coin);
            if(subProblem==-1) continue;//子问题不成立
            res = Math.min(subProblem + 1, res);
        }
        memo[amount]=(res==Integer.MAX_VALUE?-1:res);
        return memo[amount];
    }

    //2.从下到上
    public static int coinChange1(int[] coins, int amount){
        if(amount==1){
            return 1;
        }
        if(amount<1){
            return -1;
        }
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin<0){
                    continue;
                }
                min = dp[i-coin]+1<min?dp[i-coin]+1:min;
                if(min==Integer.MAX_VALUE){
                    min = -1;
                }
            }
            dp[i]=min;
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }

}
