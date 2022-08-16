package string;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay1(5));
    }

    //首先实现给定一个数字就表示出来
    //这个判断的想法挺好
    public static String countAndSay(String s) {
        List<Integer> list = new ArrayList<>();
        char m = s.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==m){
                count++;
            }else {
                sb.append(count);
                sb.append(m);
                count=1;
                m = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(m);
        return sb.toString();
    }

    //下边加上递归
    public static String countAndSay1(int n) {
        if(n==1){
            return "1";
        }
        String s = countAndSay1(n-1);
        List<Integer> list = new ArrayList<>();
        char m = s.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==m){
                count++;
            }else {
                sb.append(count);
                sb.append(m);
                count=1;
                m = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(m);
        return sb.toString();
    }

}
