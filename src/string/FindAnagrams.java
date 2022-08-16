package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        if(s.length()<p.length()){
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pCount, sCount)){
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i)-'a']++;
            sCount[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(pCount, sCount)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }


    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if(isAnagrams(s.substring(i,i+p.length()),pCount)){
                result.add(i);
            }
        }
        return result;
    }

    //判断两个词是不是同分异位词
    public static Boolean isAnagrams1(String m,String n) {
        byte[] bytes1 = n.getBytes();
        byte[] bytes2 = m.getBytes();
        Arrays.sort(bytes1);
        Arrays.sort(bytes2);
        if(Arrays.equals(bytes1, bytes2)){
            return true;
        }
        return false;
    }

    public static Boolean isAnagrams(String m,int[] nCount) {
        int[] mCount = new int[26];
        for (int i = 0; i < m.length(); i++) {
            mCount[m.charAt(i)-'a']++;
        }
        return Arrays.equals(mCount, nCount);
    }
}
