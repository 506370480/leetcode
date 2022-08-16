package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;//i和j就是双指针的表现形式
        for(;i<nums1.length&&j<nums2.length;){
            if(nums1[i]==nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
//        int index=0;
        //Array和List的一种转换方式
        int[] ts = new int[result.size()];
        for(int k=0;k<result.size();k++){
            ts[k]=result.get(k);
        }
        //Array和list的另一种转换
//        Integer[] ts = new Integer[result.size()];
//        result.toArray(ts);
        return ts;
    }
}
