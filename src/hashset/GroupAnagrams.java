package hashset;

import java.util.*;

//char数组转换为string,要使用String.valueOf(chars)
//而不是chars.toStirng()，后者输出的结果是错误的（地址）（这个方法每个对象都有，是用来打印地址的）
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (hashmap.containsKey(s)) {
                List<String> strings = hashmap.get(s);
                strings.add(str);
                hashmap.put(s, strings);
            } else {
                List<String> list1 = new ArrayList<>();
                list1.add(str);
                hashmap.put(s, list1);
            }
        }
        for (List<String> value : hashmap.values()) {
            list.add(value);
        }
        return list;
    }


    //官方题解和我的思路是一样的，但是他的简介多了，下边加注释的地方为需要改进的地方
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            //只要是判断key是否存在的，都考虑使用getOrDefault，要简便多了
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        
        //Collection<List<String>> values = map.values();
        return new ArrayList<List<String>>(map.values());
    }

}
