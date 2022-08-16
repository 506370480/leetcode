package dp;

public class LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{
                10,9,2,5,3,7,101,18}));
    }


    //此题最关键的想法是dp[i]是必须以第i个数结尾的数字
    //而我的想法是前i个数字即可，这样做是不利的
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[1] = 1;
        if (len == 1) {
            return 1;
        }
        for (int i = 2; i <= len; i++) {
            for (int j = 2; j <= i; j++) {
                if (nums[j-1] > nums[j - 2]&&nums[j-1]<nums[i-1]){
                    dp[i] = dp[i-1]++;
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }
        int max = 1;
        for (int i = 1; i <= len; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
