package greedyalgorithm;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{3, 2, 1, 1, 4}));
    }

    //��ô��̰���㷨���
    //�±������dp�ⷨ�������ٶȺ���
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) <= nums[j]&&dp[j]==true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }


    //̰�ĵ�˼���ǣ����һ��λ���ܹ������ô���λ���������λ�ö��ܵ��
    //ֻҪά��һ���ܹ����������ֵ������ʵʱ���¼���
    public static boolean canJump1(int[] nums){
        if (nums.length == 1){
            return true;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i>max){
                return false;
            }
            max = Math.max(i+nums[i],max);
        }
        return true;
    }
}
