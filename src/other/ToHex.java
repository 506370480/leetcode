package other;

import java.util.HashMap;
import java.util.Map;

public class ToHex {
    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
    public static String toHex(int num) {
        if(num==0) return "0";
        StringBuilder sb = new StringBuilder();
        String s = Integer.toBinaryString(num);
        int len = s.length()/4;
        int rem = s.length()%4;
        for (int i = s.length()-1; i>=0&&len>0; i-=4) {
            int temp = (s.charAt(i)-'0')+(s.charAt(i-1)-'0')*2+
                    (s.charAt(i-2)-'0')*4+(s.charAt(i-3)-'0')*8;
            if(temp>9){
                sb.append((char)(temp+87));
            }else{
                sb.append(temp);
            }
            len--;
        }
        int t = 0;
        for (int i = rem-1; i >= 0; i--) {
            t+=(s.charAt(i)-'0')*(Math.pow(2,rem-i-1));
        }
        if(t!=0) {
            if (t > 9) {
                sb.append((char) (t + 87));
            } else {
                sb.append(t);
            }
        }
        return sb.reverse().toString();

    }

    public static String toHex1(int num){
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            int temp = num&15;
            char c = (char)(temp+'0');
            if(temp>10) c=(char)(c-10+'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();

    }
}
