package hashset;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        intersection(new int[]{1,2,2,1},new int[]{2,2});
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            hashset.add((Integer)nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(hashset.contains((Integer)nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[] nums = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while(iterator.hasNext()){
            nums[i++] = iterator.next();
        }
        return nums;
    }
}
