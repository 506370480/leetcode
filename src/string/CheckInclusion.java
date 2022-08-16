package string;

import java.lang.reflect.Array;
import java.util.Arrays;

//�ж��ִ�ʹ������
public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1Count,s2Count)){
            return true;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            s2Count[s2.charAt(i)-'a']--;
            s2Count[s2.charAt(i+s1.length())-'a']++;
            if(Arrays.equals(s1Count,s2Count)){
                return true;
            }
        }
        return false;
    }
}
