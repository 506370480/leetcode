package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Repeatnumber {
/*        暴力解法超出了时间限制
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length-1;i++){和下边这一行效果是一样的
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }*/

    /*    public boolean containsDuplicate(int[] nums) {
            //可以先排序然后再进行
            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==nums[i+1]){
                    return true;
                }
            }
            return false;
        }*/
    public boolean containsDuplicate(int[] nums) {
        //set集合不能有重复的，可以都添加到set中，如果返回false，就可以直接返回true
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
