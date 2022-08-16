package dp;
//主要想法是找到一些数使得是所有数字的一半
//dp[i][j]表示在前i个数字中，能否找到和为j的子数组。可选择的物品和空余的容量就是状态
//选与不选第i个元素就是选择
public class SplitEqualSumSubset {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int w = sum/2;
        boolean dp[][]  = new boolean[len+1][w+1];
        for (int i = 0; i < len; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i<= len; i++) {
            for (int j = 1;j<= w;j++){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                        dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[len-1][w];
    }
}
