package string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        System.out.println(map.put("s",2));
        System.out.println(map.put("s",3));
        System.out.println(map.put("s",4));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character,String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsValue(words[i])&&!map.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }
            if(map.containsKey(pattern.charAt(i))&&!map.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),words[i]);
            }
        }
        return true;
    }
}
