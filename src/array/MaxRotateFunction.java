package array;
//1.将nums进行拼接，得到2*n的新数组，然后在其上进行滑动窗口（实际操作中只需要进行下标处理即可）

public class MaxRotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction1(new int[]{4, 3, 2, 6}));
    }
    public static int maxRotateFunction1(int[] nums) {
        int[] nums1 = new int[nums.length*2];
        int[] preSum = new int[nums.length*2];
        preSum[0] = nums[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
            nums1[i+ nums.length] = nums[i];
            sum += nums[i]*i;
        }
        for (int i = 1; i < nums1.length; i++) {
            preSum[i] = preSum[i-1]+nums1[i];
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(sum,max);
            sum = sum+nums1[i+nums.length]*(nums.length-1)-preSum[nums.length+i-1]+preSum[i];
        }
        return Math.max(sum,max);
    }
}
