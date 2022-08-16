package hashset;

import java.util.*;
//list转数组
//String[] array2 = list.toArray(new String[list.size()]);

//数组转list
//ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrays));
public class FindRestaurant {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length==0||list2.length==0){
            return null;
        }
        String res = list1[0];
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        Map<String,Integer> hashmap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashmap.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            if(hashmap.containsKey(list2[i])){
                if(i+hashmap.get(list2[i])<min){
                    list.clear();
                    res = list2[i];
                    list.add(res);
                    min = i+hashmap.get(list2[i]);
                }else if(i+hashmap.get(list2[i])==min){
                    list.add(list2[i]);
                }
            }
        }

        String[] array2 = list.toArray(new String[list.size()]);
        return array2;
    }
}
