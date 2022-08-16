package array;

import java.util.HashMap;
import java.util.Map;
//首先想到的两种方法 一是遍历左右边界，然后中间再依次相加，时间复杂度n^3
//改进为，固定左边界，然后右边界移动，时间复杂度n^2
//然后就是使用前缀和，首先构建前缀和数组，以快速计算区间和；其中的关键是如何利用前缀和数组
//首先想到的是遍历前缀和左右边界，时间复杂度也是n^2
//使用map能简化到n，但是1.在使用的过程中，将preSum[0]设为1，不然无法计算 2.在计算的过程中就计算count，而不是计算完成之后再重新计算，否则容易重复计算
public class SubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,1,-1}, 0));
    }
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int[] preSum = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
            sum+=map.getOrDefault(preSum[i+1]-k,0);
            map.put(preSum[i+1], map.getOrDefault(preSum[i+1],0)+1);
        }
        return sum;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //和为k
                if(preSum[i]-preSum[j]==k){
                    count++;
                }
            }
        }
        return count;
    }
}
