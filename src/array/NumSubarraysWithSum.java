package array;

import java.util.HashMap;
import java.util.Map;

public class NumSubarraysWithSum {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int[] preSum = new int[nums.length+1];
        int count = 0;
        preSum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
            count+=map.getOrDefault(preSum[i+1]-goal,0);
            map.put(preSum[i+1],map.getOrDefault(preSum[i+1],0)+1);
        }
        return count;
    }
}
