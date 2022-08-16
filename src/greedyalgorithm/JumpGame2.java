package greedyalgorithm;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(jumpGame1(new int[]{3, 2, 1, 1, 4}));
    }

    //动态规划可以解决，但是一顿操作猛如虎，一看超过5%，在这种贪心可以解决的问题上优先使用贪心
    //使用动态规划也要注意时间复杂度的优化
    public static int jumpGame(int[] nums){
        if(nums.length==1){
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if((i-j)<=nums[j]){
                    min = Math.min(min,dp[j]+1);
                }
            }
            dp[i] =min;
        }
        return dp[nums.length-1];
    }

    //dp就是子问题，bestIndex这个指index的位置，从哪个位置跳到当前位置的index
    public static int jumpGame1(int[] nums){
        int[] dp = new int[nums.length];
        int bestStartIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            while (i > bestStartIndex + nums[bestStartIndex]) {
                bestStartIndex ++;
            }
            dp[i] = dp[bestStartIndex] + 1;
        }
        return dp[nums.length - 1];
    }

    //下边这个是贪心算法
    //本质原理还是指可跳到当前位置，那么就可以跳到当前位置之前的所有位置
    public static int jumpGame2(int[] nums){
        //记录第一次、第二次、、直到最后所能跳到的位置，如果其中包括最后一个位置，结束
        int count = 0;
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            max = Math.max(max,i+nums[i]);
        }
        return 0;
    }

}
