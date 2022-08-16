package greedyalgorithm;

import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1,1}));
    }

    //��̬�滮
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int[][] dp = new int[g.length+1][s.length+1];
        
        //ע�⣬����ʹ��һ��for��һ��while��ʵ���������
        for (int i = 0,j=0; i <g.length&&j<s.length ; i++,j++) {
            while (j<s.length&&g[i]>s[j]){
                j++;
            }
            if(j<s.length){
                count++;
            }
        }
        return count;

        //�±����Լ�����д��dp�㷨�Ĳ��裬����ʧ����
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
