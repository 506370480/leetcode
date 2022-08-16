package greedyalgorithm;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(jumpGame1(new int[]{3, 2, 1, 1, 4}));
    }

    //��̬�滮���Խ��������һ�ٲ������绢��һ������5%��������̰�Ŀ��Խ��������������ʹ��̰��
    //ʹ�ö�̬�滮ҲҪע��ʱ�临�Ӷȵ��Ż�
    public static int jumpGame(int[] nums){
        if(nums.length==1){
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if((i-j)<=nums[j]){
                    min = Math.min(min,dp[j]+1);
                }
            }
            dp[i] =min;
        }
        return dp[nums.length-1];
    }

    //dp���������⣬bestIndex���ָindex��λ�ã����ĸ�λ��������ǰλ�õ�index
    public static int jumpGame1(int[] nums){
        int[] dp = new int[nums.length];
        int bestStartIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            while (i > bestStartIndex + nums[bestStartIndex]) {
                bestStartIndex ++;
            }
            dp[i] = dp[bestStartIndex] + 1;
        }
        return dp[nums.length - 1];
    }

    //�±������̰���㷨
    //����ԭ����ָ��������ǰλ�ã���ô�Ϳ���������ǰλ��֮ǰ������λ��
    public static int jumpGame2(int[] nums){
        //��¼��һ�Ρ��ڶ��Ρ���ֱ���������������λ�ã�������а������һ��λ�ã�����
        int count = 0;
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            max = Math.max(max,i+nums[i]);
        }
        return 0;
    }

}
