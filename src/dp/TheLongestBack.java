package dp;
//������ַ������ܾ����һ����Ŀ
//���Ǹо��ֽ�������Ⲣ���ǽṹ��ȫ��ͬ�ģ����Էֽ����С���ӽṹ��

//��Ҫ˼�룺һ�������ַ������˼�����ͬ��Ԫ�أ���ɵ��µ��ַ��������ǻ��Ĵ�
//Ҳ�����õ�����С���ֽṹ�ģ�ÿ����õ���С���ӽṹ������С�Ļ��Ĵ���Ȼ�����жϸ�����ʱ�򣬷����ڲ��ַ������жϣ�����

import java.lang.reflect.Array;
import java.util.Arrays;

public class TheLongestBack {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] nums = new boolean[len][len];
        for(int i=0;i<len;i++){
            nums[i][i]=true;
            for(int j=0;j<=i;j++){
                if(i==j){
                    nums[i][j]=true;
                    break;
                    //indexof���ص����ض����ַ���Ӧ��λ�ã���charat���������ķ����ַ�
                } else if(s.charAt(i)==s.charAt(j)){
                    if(j==i-1){
                        nums[i][j]=true;
                        break;
                    } else{
                        nums[i][j]=nums[i-1][j+1];
                        continue;
                    }
                }
            }
        }
        //��ӡ����ʹ��Arrays.toString
        //��ά����ʹ��deepToString
        int max=0;
        String maxLen = null;
        System.out.println(Arrays.deepToString(nums));
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(nums[i][j]==true){
                    if(i-j>max) {
                        max = i-j;
                        maxLen = s.substring(j,i+1);
                    }
                }
            }
        }
        System.out.println(max);
        return maxLen;
    }
}
