package array;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits1(5)));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            char[] chars = Integer.toBinaryString(i).toCharArray();
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if(chars[j]=='1'){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
    public static int[] countBits1(int n){
        int[] res = new int[n+1];
        res[0] = 0;
        if(n>1){
            res[1] = 1;
        }
        //这里找离得最近的那个2的倍数的话，不需要使用log
        int multi = 1;
        for (int i = 2; i <= n ; i++) {
            if(i==multi*2){
                multi*=2;
                res[i]=1;
            }else{
                res[i] = res[i - multi]+1;
            }
        }
        return res;
    }
}
