package dp;
//��Ҫ�뷨���ҵ�һЩ��ʹ�����������ֵ�һ��
//dp[i][j]��ʾ��ǰi�������У��ܷ��ҵ���Ϊj�������顣��ѡ�����Ʒ�Ϳ������������״̬
//ѡ�벻ѡ��i��Ԫ�ؾ���ѡ��
public class SplitEqualSumSubset {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int w = sum/2;
        boolean dp[][]  = new boolean[len+1][w+1];
        for (int i = 0; i < len; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i<= len; i++) {
            for (int j = 1;j<= w;j++){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                        dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[len-1][w];
    }
}
