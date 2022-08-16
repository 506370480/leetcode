package hashset;

import java.util.*;

//getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
//注意是key而不是value
//下边的语法是合法的，if（一个东西为null||一个东西的调用），当检测到为null的时候，后边就不再执行了
//如：if(hashmap1.get(nums2[i])==null||hashmap.get(nums2[i])> hashmap1.get(nums2[i]))
public class Intersection2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect1(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    //这里自己使用了两个map存储，第一个存储第一个nums1里边的数字，第二个存储答案
    //为什么不直接把第二个map换成答案来存储，最终得到答案呢？
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        Map<Integer,Integer> hashmap1 = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            hashmap.put(nums1[i], hashmap.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(hashmap.containsKey(nums2[i])){
                if(hashmap1.get(nums2[i])==null||hashmap.get(nums2[i])> hashmap1.get(nums2[i])){
                    hashmap1.put(nums2[i],hashmap1.getOrDefault(nums2[i],0)+1);
                    count++;
                }
            }
        }
        int[] res = new int[count];
        //List<Integer> list  = new ArrayList<>();
        for (Integer integer : hashmap1.keySet()) {
            Integer integer1 = hashmap1.get(integer);
            for (int i = 0; i < integer1; i++) {
                res[count-1] = integer;
                count--;
            }
        }
        return res;

    }

    //在不能确保数组大小的时候，可以先搞一个最大范围的数组，然后在Arrays.copyOfRange
    public static int[] intersect1(int[] nums1, int[] nums2){
        if(nums1.length>nums2.length){
            return intersect1(nums2,nums1);
        }
        int index=0;
        Map<Integer,Integer> hashmap = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            hashmap.put(nums1[i], hashmap.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
                int count = hashmap.getOrDefault(nums2[i], 0);
                if(count>0){
                    res[index] = nums2[i];
                    index++;
                    count--;
                    if(count>0){
                        hashmap.put(nums2[i],count);
                    }else{
                        hashmap.remove(nums2[i]);
                    }
                }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
