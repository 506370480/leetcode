package dp;

import java.util.Arrays;

//��״������ζ�ŵ�һ�����Ӻ����һ��������ֻ��ѡ��һ��͵�ԣ���˿��԰Ѵ˻�״���з�������Լ��Ϊ�����������з��������⣺
//�ڲ�͵�Ե�һ�����ӵ�����£��� nums[1:]nums[1:]����������� p1
//�ڲ�͵�����һ�����ӵ�����£��� nums[:n-1]nums[:n?1]����������� p2
//�ۺ�͵������ Ϊ������������Ľϴ�ֵ���� max(p1,p2)��
public class Rob2 {
    public static void main(String[] args) {
        System.out.println(rob2(new int[]{2}));
    }
    public static int rob2(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        //copyOfRange����ҿ�
        int rob = rob(Arrays.copyOfRange(nums, 1, nums.length));
        int rob1 = rob(Arrays.copyOfRange(nums, 0, nums.length-1));
        return Math.max(rob,rob1);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0]=0;
        if(len>=1) {
            dp[1] = nums[0];
        }
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }
}
