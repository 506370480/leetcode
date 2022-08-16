package hashset;

import java.util.Iterator;
import java.util.LinkedList;

//基本原则：底层为数组+链表，和HashSet不同的是链表中存储的是Key-Value结点
//当使用iterator.hasNext()并且想要remove的时候，必须使用iterator.remove()
//当调用hasNext方法的时候，只是判断下一个元素的有无，并不移动指针
//当调用next方法的时候，向下移动指针，并且返回指针指向的元素，如果指针指向的内存中没有元素，会报异常。
//remove方法删除的元素是指针指向的元素。如果当前指针指向的内存中没有元素，那么会抛出异常。
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
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
                //remove以后数量就变化了，牛牛，这样直接就跳过了hasNext(),牛牛
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
