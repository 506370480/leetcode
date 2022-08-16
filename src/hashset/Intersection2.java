package hashset;

import java.util.*;

//getOrDefault() ������ȡָ�� key ��Ӧ�� value������Ҳ��� key ���򷵻����õ�Ĭ��ֵ��
//ע����key������value
//�±ߵ��﷨�ǺϷ��ģ�if��һ������Ϊnull||һ�������ĵ��ã�������⵽Ϊnull��ʱ�򣬺�߾Ͳ���ִ����
//�磺if(hashmap1.get(nums2[i])==null||hashmap.get(nums2[i])> hashmap1.get(nums2[i]))
public class Intersection2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect1(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    //�����Լ�ʹ��������map�洢����һ���洢��һ��nums1��ߵ����֣��ڶ����洢��
    //Ϊʲô��ֱ�Ӱѵڶ���map���ɴ����洢�����յõ����أ�
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

    //�ڲ���ȷ�������С��ʱ�򣬿����ȸ�һ�����Χ�����飬Ȼ����Arrays.copyOfRange
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
