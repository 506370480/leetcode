package array;

import java.util.ArrayList;
import java.util.List;
//1.// Calling remove(index) numbers.remove(1); //removing object at index 1 i.e. 2nd Object, which is 2 //Calling remove(object) numbers.remove(new Integer(3));
//2.remove(object o)��ֻ�Ƴ���һ��Ԫ��
public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println(findDuplicates3(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
    //ʹ��o(1)��ʱ�临�Ӷ�
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if(list.contains(num)){
                continue;
            }
            list.add(num);
        }
        for (int num : nums) {
            if(list.contains(num)){
                list.remove((Integer)num);
                continue;
            }
            list.add(num);
        }
        return list;
    }

    //���������o(n)
    //by default boolean variables are initialized with false
    public static List<Integer> findDuplicates1(int[] nums){
        boolean[] bools = new boolean[nums.length+1];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(bools[nums[i]]){
                result.add(nums[i]);
            }
            bools[nums[i]]=true;
        }
        return result;
    }

    //ʹ��������ԭ���ж�
    public static List<Integer> findDuplicates2(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if(nums[x-1]<0){
                list.add(x);
            }
            nums[x-1]*=-1;
        }
        return list;
    }

    //ͬ����˼·��ʹ��ƫ��ֵ��ԭ��hash����ʹ���±��ֵһһӳ��
    public static List<Integer> findDuplicates3(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(nums[i]>100000){
                x = nums[i]-100000;
            }
            if(nums[x-1]>100000){
                list.add(x);
            }
            nums[x-1]+=100000;
        }
        return list;
    }
}
