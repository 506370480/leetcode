package dp;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    //�������⣬�������ͣ��������������nƽ������������
    //������ö�̬�滮�����ǵ�һ������ǰ����������кͼ���������ǲ��Ǵ���������������������;������������
    public static int maxSubArray(int[] nums) {
        int sub = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(sub+nums[i]>nums[i]){
                sub = sub+nums[i];
                max = sub>max?sub:max;
            }else{
                sub = nums[i];
                max = sub>max?sub:max;
            }
        }
        return max;
    }
}
