package hashset;

import java.util.Iterator;
import java.util.LinkedList;

//����ԭ�򣺵ײ�Ϊ����+������HashSet��ͬ���������д洢����Key-Value���
//��ʹ��iterator.hasNext()������Ҫremove��ʱ�򣬱���ʹ��iterator.remove()
//������hasNext������ʱ��ֻ���ж���һ��Ԫ�ص����ޣ������ƶ�ָ��
//������next������ʱ�������ƶ�ָ�룬���ҷ���ָ��ָ���Ԫ�أ����ָ��ָ����ڴ���û��Ԫ�أ��ᱨ�쳣��
//remove����ɾ����Ԫ����ָ��ָ���Ԫ�ء������ǰָ��ָ����ڴ���û��Ԫ�أ���ô���׳��쳣��
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap ����Ϊ [[1,1]]
        myHashMap.put(2, 2); // myHashMap ����Ϊ [[1,1], [2,2]]
        myHashMap.get(1);    // ���� 1 ��myHashMap ����Ϊ [[1,1], [2,2]]
        myHashMap.get(3);    // ���� -1��δ�ҵ�����myHashMap ����Ϊ [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap ����Ϊ [[1,1], [2,1]]���������е�ֵ��
        myHashMap.get(2);    // ���� 1 ��myHashMap ����Ϊ [[1,1], [2,1]]
        myHashMap.remove(2); // ɾ����Ϊ 2 �����ݣ�myHashMap ����Ϊ [[1,1]]
        myHashMap.get(2);    // ���� -1��δ�ҵ�����myHashMap ����Ϊ [[1,1]]
    }
    public static final int BASE = 769;
    private LinkedList<int[]>[] list;

    public MyHashMap() {
        list = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            list[i] = new LinkedList<int[]>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<int[]> iterator = list[h].iterator();
        while (iterator.hasNext()){
            int[] next = iterator.next();
            if(next[0]==key){
                next[1] = value;
                return;
            }
        }
        list[h].add(new int[]{key,value});

    }

    public int get(int key) {
        int h = hash(key);
        Iterator<int[]> iterator = list[h].iterator();
        while (iterator.hasNext()){
            int[] next = iterator.next();
            if(next[0]==key){
                return next[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<int[]> iterator = list[h].iterator();
        while (iterator.hasNext()){
            int[] next = iterator.next();
            if(next[0]==key){
                //remove�Ժ������ͱ仯�ˣ�ţţ������ֱ�Ӿ�������hasNext(),ţţ
                //While iterating over a regular Collection, you must use Iterator.remove();
                iterator.remove();
            }
        }
        return;
    }
    public int hash(int key){
        return key % BASE;
    }
}
