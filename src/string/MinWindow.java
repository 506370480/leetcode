package string;

import java.util.HashMap;
import java.util.Map;

/**
 * ������Ŀ
 * ʹ�û�������
 * 1.����ж��Ƿ������ִ�����ʲôʱ�����һ������ڣ�ʲôʱ����߻�������
 * 2.  ���顢map��ʹ��map��¼
 * 3. ����ҵ�����С��ֵ���������󷵻��أ�
 */

//subString ����ҿ�
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        String res = s+t;
        int l = 0;
        int r = 1;
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        sMap.put(s.charAt(0),1);
        while(r<=s.length()&&l<r){
            if(!isContain(sMap,tMap)) {
                r++;
                if (r != s.length() + 1) {
                    sMap.put(s.charAt(r - 1), sMap.getOrDefault(s.charAt(r - 1), 0) + 1);
                }
            }
            if(isContain(sMap,tMap)){
                res = res.length()>s.substring(l,r).length() ? s.substring(l,r) : res;
                sMap.put(s.charAt(l),sMap.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
        }
        return res.equals(s+t)?"":res;
    }
    public static boolean isContain(Map<Character, Integer> sMap,Map<Character, Integer> tMap){
        for (Character c : tMap.keySet()) {
            if(!sMap.containsKey(c)){
                return false;
            }
            if(sMap.get(c)<tMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
