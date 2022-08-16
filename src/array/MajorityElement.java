package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement1(new int[]{3,2,3}));
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=0;
        while(j<nums.length) {
            if(i==j){
                j+=1;
            }
            while(j<nums.length&&nums[i]==nums[j]){
                j++;
            }
            if((j-i)>nums.length/2){
                return nums[i];
            }
            i++;
        }
        return 0;
        //直接return nums[nums.length / 2]即可，这个是按照题目来的，很神奇
    }

    public static int majorityElement1(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer)>nums.length/2){
                return integer;
            }
        }
        return 0;
    }
}
