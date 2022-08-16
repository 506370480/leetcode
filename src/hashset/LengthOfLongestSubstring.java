package hashset;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    //�����뵽�ľ������ÿ���ַ�Ϊ���һ���ַ���ʱ�������ظ��ĳ��ȣ��Ӻ���ǰ��
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //��������ָ��
        //���ָ��̶����ƶ��Ҳ�ָ�룬�����������Ҳ���ַ���set�д���ʱ�����ָ���ƶ�����set���Ƴ�ԭ���ָ���Ӧ���ַ���������ȡ���ڳ��ȵ����ֵ
        int left = 0,right = 0;
        Set<Character> hashset = new HashSet<>();
        for (; right < s.length(); right++) {
            while (hashset.contains(s.charAt(right))){
                hashset.remove(s.charAt(left));
                left++;
            }
            hashset.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }
        return max;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < s.length(); i++) {
//            int count = 0;
//            Set<Character> hashset = new HashSet<>();
//            for (int j = i; j >= 0 ; j--) {
//                if(hashset.contains(s.charAt(j))){
//                    break;
//                }
//                hashset.add(s.charAt(j));
//                count++;
//            }
//            max=Math.max(count,max);
//        }
//        return max;
    }
}
