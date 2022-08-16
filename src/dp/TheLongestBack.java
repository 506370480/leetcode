package dp;
//最长回文字符串，很经典的一个题目
//但是感觉分解的子问题并不是结构完全相同的，可以分解成最小的子结构吗？

//主要思想：一个回文字符串两端加上相同的元素，组成的新的字符串依旧是回文串
//也是利用到了最小的字结构的，每次求得的最小的子结构就是最小的回文串，然后再判断更长的时候，返回内部字符串的判断，即可

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
                    //indexof返回的是特定的字符对应的位置，而charat才是真正的返回字符
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
        //打印数组使用Arrays.toString
        //多维数组使用deepToString
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
