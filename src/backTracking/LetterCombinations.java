package backTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    static List<String> res = new LinkedList<>();
    static String s = "";
    static Map<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        dfs(digits,0);
        return res;
    }
    public static void dfs(String digits,int index){
        if(s.length()==digits.length()||index==digits.length()){
            res.add(new String(s));
            return;
        }
        String tmp = map.get(digits.charAt(index)-'0');
        for (int j = 0; j < tmp.length(); j++) {
            s+=tmp.charAt(j);
            dfs(digits,index+1);
            s = s.substring(0, s.length() - 1);
        }
    }

}
