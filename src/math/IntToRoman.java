package math;

import java.util.*;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {

        Map<Integer,String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //所有可能的都列出来
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        StringBuilder sb = new StringBuilder();
        Set<Integer> integers = map.keySet();
        for (Integer integer : map.keySet()) {
            while(num-integer>=0){
                sb.append(map.get(integer));
                num-=integer;
            }
        }
        return sb.toString();

    }

    public static String intToRoman1(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while(num-values[i]>=0){
                sb.append(symbols[i]);
                num-=values[i];
            }
            if(num==0){
                break;
            }
        }
        return sb.toString();
    }
}
