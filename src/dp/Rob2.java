package dp;

import java.util.Arrays;

//环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题：
//在不偷窃第一个房子的情况下（即 nums[1:]nums[1:]），最大金额是 p1
//在不偷窃最后一个房子的情况下（即 nums[:n-1]nums[:n?1]），最大金额是 p2
//综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)。
public class Rob2 {
    public static void main(String[] args) {
        System.out.println(rob2(new int[]{2}));
    }
    public static int rob2(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        //copyOfRange左闭右开
        int rob = rob(Arrays.copyOfRange(nums, 1, nums.length));
        int rob1 = rob(Arrays.copyOfRange(nums, 0, nums.length-1));
        return Math.max(rob,rob1);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0]=0;
        if(len>=1) {
            dp[1] = nums[0];
        }
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }
}
