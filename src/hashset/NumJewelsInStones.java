package hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//数组用length，字符串用length(),列表用size()
public class NumJewelsInStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aaAAasdfv"));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> hashset = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            hashset.add(jewels.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if(hashset.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
