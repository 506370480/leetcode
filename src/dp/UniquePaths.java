package dp;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths1(3, 7));
    }
    public static int uniquePaths(int m, int n) {
        if(m<n){
            int tmp = m;
            m=n;
            n = tmp;
        }
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[2][1] = 1;
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j<=Math.min(i,n) ; j++) {
                if(dp[i][j]==0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                    if(i<=n&&j<=n) {
                        dp[j][i] = dp[i][j];
                    }
                }
            }
        }
        return dp[m][n];

    }

    public static int uniquePaths1(int m, int n) {
        if(m<n){
            int tmp = m;
            m=n;
            n = tmp;
        }
        int[][] dp = new int[m+1][n+1];
        int rec = rec(dp, m, n);
        return rec;
    }
    public static int rec(int[][] dp,int m,int n){
        if(n==1||m==1){
            return 1;
        }
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[2][1] = 1;
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        dp[m][n] = rec(dp,m-1,n)+rec(dp,m,n-1);
        return dp[m][n];
    }
}
