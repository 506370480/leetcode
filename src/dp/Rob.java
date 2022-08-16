package dp;

import java.util.Arrays;

public class Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
    //数组非相邻情况下的最大值
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        if(nums.length>1){
            dp[1] = nums[1]>nums[0]?nums[1]:nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]+dp[i-2]>dp[i-1]){
                dp[i] = nums[i]+dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }
}
