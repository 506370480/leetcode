package hashset;

import java.util.Iterator;
import java.util.LinkedList;

//使用链表比较合适（删除和新增比较好）
public class MyHashSet {
    //注意，这个基数需要选择一个质数
    public static final int BASE = 769;
    private LinkedList[] linkedList;
    public MyHashSet() {
        linkedList = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            linkedList[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = linkedList[h].iterator();
        while (iterator.hasNext()){
            Integer next =  iterator.next();
            if(next.equals(key)){
                return;
            }
        }
        linkedList[h].addLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = linkedList[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if(element.equals(key)){
                //注意这个remove的话必须是object，如果是int类型的就是删除index
                linkedList[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = linkedList[h].iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(key)){
                return true;
            }
        }
        return false;
    }

    public int hash(int key){
        return key % BASE;
    }
}
