package string;

import java.util.Arrays;
//int[] toString 会得到对象地址
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("10", "10"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int n = Math.max(a.length(), b.length());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            carry += i<a.length()?(a.charAt(a.length()-1-i)-'0'):0;
            carry += i<b.length()?(b.charAt(b.length()-1-i)-'0'):0;
            sb.append((char)((sum+carry)%2+'0'));
            carry=(sum+carry)>=2?1:0;
        }
        if(carry==1){
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }

    public static String addBinary1(String a, String b) {
        char[] chars = a.toCharArray();
        char[] chars1 = b.toCharArray();
        int carry = 0;
        if(chars.length<chars1.length){
            char[] temp = chars;
            chars = chars1;
            chars1 = temp;
        }
        int[] result = new int[chars.length+1];
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i< chars1.length){
                sum = Integer.parseInt(chars[chars.length-1-i]+"")+Integer.parseInt(chars1[chars1.length-1-i]+"");
            }else{
                sum = Integer.parseInt(chars[chars.length-1-i]+"");
            }
            result[result.length-1-i] = (sum+carry)%2;
            carry=(sum+carry)>=2?1:0;
        }
        result[result.length- chars.length-1]=carry==1?1:0;
        //会输入带[,]的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        String res =  sb.toString();
        if(res.indexOf('1')==-1){
            return "0";
        }
        return sb.substring(res.indexOf('1'),res.length());
        //String res = Arrays.toString(result);
        //int first = res.indexOf('1');
        //return res.substring(first,res.length());
    }


    public static String addBinary2(String a, String b) {
        long res = Long.parseLong(a,2)+Long.parseLong(b,2);
        return Long.toBinaryString(res);
    }
}
