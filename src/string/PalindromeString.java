package string;

import java.util.ArrayList;
import java.util.List;
//1.indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
//如果没有找到匹配的字符串则返回 -1,返回的是位置，而不是这个地方的值是什么，这个值得注意。

//2.需要使用charAt()
public class PalindromeString {
    public static void main(String[] args) {
        String s = "race a car";
        boolean palindrome = isPalindrome3(s);
        System.out.println(palindrome);
    }
    //下边这个方法是自己的方法，首先正则表达式，然后通过循环比较
    //但是时间复杂度非常的高，是o(n)数量级的
    //String 可以为null,而int默认值为0，Interger才会为null
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s=s.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");
        s=s.replaceAll("[\\s*|\t|\r|\n]", "");
        List list = new ArrayList();
        for(int i=0;i<s.length()/2;i++){
            s.charAt(1);
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


    //2.正则表达式+字符串反转
    public static boolean isPalindrome2(String s){
        s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();
        String s1 = new StringBuffer(s).reverse().toString();
        return s.equals(s1);
    }

    //3.双指针，遇到特殊字符要跳过，然后进行判断
    //如果不用双指针，只能用正则表达式去除其他字符了，用双指针可以跳过其他的字符
    public static boolean isPalindrome3(String s){
        if(s==null||s.length()==0){
            return true;
        }
        s.toLowerCase();
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            while(i<j&&!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j&&!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;


    }


}
