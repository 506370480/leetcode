package array;

public class MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = nums[l];
        while(r<nums.length&&!(r==nums.length-1&&sum<target)) {
            if (sum >= target) {
                min = Math.min(min, r-l+1);
                sum-=nums[l];
                l++;
            }else{
                r++;
                sum+=nums[r];
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
