package dp;

public class BackpackProblem01 {
    public static void main(String[] args) {
        System.out.println(backpack(3, 4, new int[]{2, 1, 3}, new int[]{2, 2, 3}));
    }

    public static int backpack(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {//n个物品
            for (int j = 1; j <= w; j++) {//m个空间
                if (j - wt[i - 1] < 0) {//剩余的j个空间比第i个物品的重量还要重，那么第i个物品自然加不进去？
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            //不把第i个物品加入背包
                            dp[i - 1][j],
                            //把第i个物品加入背包
                            dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }
}
