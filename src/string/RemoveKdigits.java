package string;

import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits1("10200", 1));
    }
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuffer buffer = new StringBuffer();
        int index = 0;
        int i = 0;
        if(n<=k){
            return "0";
        }
        for (int j = 0; j < n- k; j++) {
            int min = Integer.MAX_VALUE;
            for (i = index+1; i < k + j +1 && i<n; i++) {
                if(min>num.charAt(i)-'0'){
                    min = num.charAt(i)-'0';
                    index = i;
                }
            }
            buffer.append(min);
        }
        String res = buffer.toString();
        for (int j = 0; j < res.length(); j++) {
            if(res.charAt(j)!='0' ){
                return res.substring(j,res.length());
            }
        }
        return "0";
    }

    public static String removeKdigits1(String num, int k){
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        int len = n-k;
        stack.push(num.charAt(0));
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty()&&stack.peek()>num.charAt(i)){
                if(k==0){
                    break;
                }
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString().substring(0,len);
        for (int j = 0; j < res.length(); j++) {
            if(res.charAt(j)!='0' ){
                return res.substring(j,res.length());
            }
        }
        return "0";
    }
}
