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
    //�������֮�ͣ���Ȼʹ�õ���hashmap��������ȫû���õ����裬�����ϻ��Ǻ�ʹ����������һ����
    //hash���ڲ�ѯ�����±ߵĽ���
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
