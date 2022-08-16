package hashset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = new int[0];
        System.out.println(Arrays.toString(twoSum(new int[]{2, 11, 5, 7}, 9)));
    }
    //这个两数之和，虽然使用到了hashmap，但是完全没有用到精髓，本质上还是和使用数组做是一样的
    //hash快在查询，见下边的解析
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(i, nums[i]);
        }
        Set<Integer> keySet = hashmap.keySet();
        for(int i = 0;i<hashmap.size();i++){
            for (int j = i+1; j < hashmap.size(); j++) {
                if(hashmap.get(i)+hashmap.get(j)==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a = target - nums[i];
            if(hashmap.containsKey(a)){
                return new int[]{i,hashmap.get(a)};
            }
            hashmap.put(nums[i],i );
        }
        return new int[0];
    }
}
