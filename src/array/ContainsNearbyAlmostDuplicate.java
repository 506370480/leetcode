package array;

import java.util.Properties;

/*
package array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-3,3,-6},2,3));
    }
    public static  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        if(nums.length < 2 || k==0){
            return false;
        }
        int l = 0;
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(set.size()<=k){
                if(set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
            }else{
                set.remove((Integer) nums[l]);
                if(set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
                l++;
            }
            if(set.size()>1&&Math.abs(set.last()-set.first())<=t&&Math.abs(i-l-1)<=k){
                return true;
            }
        }
        return false;
    }
}
*/
public class ContainsNearbyAlmostDuplicate {

}