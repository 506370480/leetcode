package string;

import java.util.Arrays;

public class DiStringMatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }
    public static int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];
        int l=0,r=s.length();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='I'){
                res[index]=l;
                l++;
                index++;
            }else{
                res[index] = r;
                r--;
                index++;
            }
        }
        res[index] = l;
        return res;
    }
}
