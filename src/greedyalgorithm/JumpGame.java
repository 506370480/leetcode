package greedyalgorithm;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{3, 2, 1, 1, 4}));
    }

    //怎么用贪心算法解决
    //下边这个是dp解法，但是速度很慢
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) <= nums[j]&&dp[j]==true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }


    //贪心的思想是，如果一个位置能够到达，那么这个位置左侧所有位置都能到达。
    //只要维护一个能够跳到的最大值，并且实时更新即可
    public static boolean canJump1(int[] nums){
        if (nums.length == 1){
            return true;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i>max){
                return false;
            }
            max = Math.max(i+nums[i],max);
        }
        return true;
    }
}
