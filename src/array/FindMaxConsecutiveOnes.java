package array;

public class FindMaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum=nums[0]==1?1:0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==1){
                sum+=1;
                max = Math.max(max,sum);
            }else {
                sum = 0;
            }
        }
        return max;
    }
}
