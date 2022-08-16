package hashset;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    //最先想到的就是求出每个字符为最后一个字符的时候的最长不重复的长度，从后向前求
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //设置两个指针
        //左侧指针固定，移动右侧指针，当窗口内最右侧的字符在set中存在时，左侧指针移动并从set中移除原左侧指针对应的字符，这样再取窗口长度的最大值
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
