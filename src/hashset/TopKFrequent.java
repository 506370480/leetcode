package hashset;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(1,2);
        hashmap.put(2,5);
        System.out.println(hashmap.entrySet());
        Set<Map.Entry<Integer, Integer>> entries = hashmap.entrySet();
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(entries.hashCode());
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(hashmap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()- o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
