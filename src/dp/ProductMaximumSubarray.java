package dp;

import java.util.Arrays;

public class ProductMaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        int[] dpMin = new int[len+1];
        dp[1]=nums[0];
        for(int i=2;i<=len;i++){
            dp[i] = Math.max(Math.max(dp[i-1]*nums[i-1],nums[i-1]),dpMin[i-1]*nums[i-1]);
            dpMin[i] = Math.min(Math.min(dp[i-1]*nums[i-1],nums[i-1]),dpMin[i-1]*nums[i-1]);

        }
        int max = nums[0];
        for (int i = 1; i <= len; i++) {
            max=max>dp[i]?max:dp[i];
        }
        return max;
    }
}
