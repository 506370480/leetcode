package hashset;

import java.util.*;

//char����ת��Ϊstring,Ҫʹ��String.valueOf(chars)
//������chars.toStirng()����������Ľ���Ǵ���ģ���ַ�����������ÿ�������У���������ӡ��ַ�ģ�
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


    //�ٷ������ҵ�˼·��һ���ģ��������ļ����ˣ��±߼�ע�͵ĵط�Ϊ��Ҫ�Ľ��ĵط�
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            //ֻҪ���ж�key�Ƿ���ڵģ�������ʹ��getOrDefault��Ҫ������
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        
        //Collection<List<String>> values = map.values();
        return new ArrayList<List<String>>(map.values());
    }

}
