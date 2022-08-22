package other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//×î¾ÃÎ´Ê¹ÓÃ
public class LRUCache {
    int[] ints;
    Queue<Integer> queue = new LinkedList<>();
    int capacity;
    Map<Integer,Integer> map= new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.ints = new int[capacity];
    }

    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
        int temp = ints[0];
        ints[0] = key;
        for (int i = 1; i < capacity; i++) {
            if(temp==key){
                break;
            }
            int m = ints[i];
            ints[i] = temp;
            temp = m;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            map.put(key,value);
            int temp = ints[0];
            ints[0] = key;
            for (int i = 1; i < capacity; i++) {
                if(temp==key){
                    break;
                }
                int m = ints[i];
                ints[i] = temp;
                temp = m;
            }
            return;
        }
        if(ints[capacity-1]!=0){
            map.remove(ints[capacity-1]);
        }

        map.put(key,value);

        int temp = ints[0];
        ints[0] = key;
        for (int i = 1; i < capacity; i++) {
            if(temp==key){
                break;
            }
            int m = ints[i];
            ints[i] = temp;
            temp = m;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.get(2);
        obj.put(2,6);
        obj.get(1);
        obj.put(1,5);
        obj.put(1,2);
        obj.get(1);
    }
}
