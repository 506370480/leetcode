package hashset;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            if(hashmap.containsKey(nums[i])){
                if(i-hashmap.get(nums[i])<=k){
                    return true;
                }else{
                    hashmap.put(nums[i],i);
                }
            }else{
                hashmap.put(nums[i],i);
            }
        }
        return false;
    }
}
