package hashset;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "titli"));
        String s = "paper";
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> hashmap = new HashMap<>();
        Map<Character,Character> hashmap1 = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(hashmap.containsKey(s.charAt(i))){
                if(hashmap.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else if(hashmap1.containsKey(t.charAt(i))){
                if(hashmap1.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }else{
                hashmap.put(s.charAt(i),t.charAt(i));
                hashmap1.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}
