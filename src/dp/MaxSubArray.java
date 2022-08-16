package dp;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    //经典问题，最大子序和，如果暴力求解就是n平方的数量级的
    //如果是用动态规划，就是第一个数的前的最大子序列和加上这个数是不是大于这个数，否则最大子序和就是这个数本身
    public static int maxSubArray(int[] nums) {
        int sub = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(sub+nums[i]>nums[i]){
                sub = sub+nums[i];
                max = sub>max?sub:max;
            }else{
                sub = nums[i];
                max = sub>max?sub:max;
            }
        }
        return max;
    }
}
