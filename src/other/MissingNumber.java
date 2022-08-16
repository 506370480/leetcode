package other;

import java.util.ArrayList;
import java.util.List;
//ע��remove,�����������֣�����index,��������object,����ɾ���ض���object
//�����Ҫɾ���ض������֣�����Ҫʹ�ã�Integer����ת���ɰ�װ��


//length ��Arrays ��int[]�� double[]�� String[]�� �� ȡ��Array�ĳ���
//length������String related Object ��String�� StringBuilder�� etc�� �� ȡ���ַ����ĳ���
//size������Collection Object ��ArrayList�� Set�� etc�� �� ȡ�ü��ϵĴ�С
public class MissingNumber {
    public static void main(String[] args) {
        int i = missingNumber3(new int[]{3, 0, 1});
        System.out.println(i);
    }

    //����������֣�����ɾ�����֣�ʱ�临�ӶȺܸ�
    public static int missingNumber(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=length;i++){
            list.add(i);
        }
        for(int i=0;i<length;i++){
            list.remove((Integer) nums[i]);
        }
        return list.get(0);
    }

    //������,�ܼ��Ҳ������
    public static int missingNumber2(int[] nums){
        int sum=0;
        int n = nums.length;
        for(int i:nums){
            sum+=i;
        }
        return n*(n+1)/2-sum;
    }

    //ʹ�������⣬�������ظ����ֵ�����ܼ�
    //a^a=0���Լ����Լ�������0
    //a^0=a���κ����ֺ�0��򻹵������Լ�
    //a^b^c=a^c^b�����������н�����
    public static int missingNumber3(int[] nums){
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i]^(i+1);
        }
        return xor;
    }
}
