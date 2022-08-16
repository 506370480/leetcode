package dp;

public class BackpackProblem01 {
    public static void main(String[] args) {
        System.out.println(backpack(3, 4, new int[]{2, 1, 3}, new int[]{2, 2, 3}));
    }

    public static int backpack(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {//n����Ʒ
            for (int j = 1; j <= w; j++) {//m���ռ�
                if (j - wt[i - 1] < 0) {//ʣ���j���ռ�ȵ�i����Ʒ��������Ҫ�أ���ô��i����Ʒ��Ȼ�Ӳ���ȥ��
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            //���ѵ�i����Ʒ���뱳��
                            dp[i - 1][j],
                            //�ѵ�i����Ʒ���뱳��
                            dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }
}
