package array;

import java.util.HashMap;
import java.util.Map;
//�����뵽�����ַ��� һ�Ǳ������ұ߽磬Ȼ���м���������ӣ�ʱ�临�Ӷ�n^3
//�Ľ�Ϊ���̶���߽磬Ȼ���ұ߽��ƶ���ʱ�临�Ӷ�n^2
//Ȼ�����ʹ��ǰ׺�ͣ����ȹ���ǰ׺�����飬�Կ��ټ�������ͣ����еĹؼ����������ǰ׺������
//�����뵽���Ǳ���ǰ׺�����ұ߽磬ʱ�临�Ӷ�Ҳ��n^2
//ʹ��map�ܼ򻯵�n������1.��ʹ�õĹ����У���preSum[0]��Ϊ1����Ȼ�޷����� 2.�ڼ���Ĺ����оͼ���count�������Ǽ������֮�������¼��㣬���������ظ�����
public class SubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,1,-1}, 0));
    }
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int[] preSum = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
            sum+=map.getOrDefault(preSum[i+1]-k,0);
            map.put(preSum[i+1], map.getOrDefault(preSum[i+1],0)+1);
        }
        return sum;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //��Ϊk
                if(preSum[i]-preSum[j]==k){
                    count++;
                }
            }
        }
        return count;
    }
}
