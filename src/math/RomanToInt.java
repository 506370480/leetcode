package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        //所有可能的都列出来
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); ) {
            if(i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                sum+=map.get(s.substring(i,i+2));
                i+=2;
            }else{
                sum+=map.get(s.substring(i,i+1));
                i++;
            }
        }
        return sum;
    }
    }
