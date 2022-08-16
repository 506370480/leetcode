package hashset;

import java.util.Iterator;
import java.util.LinkedList;

//ʹ������ȽϺ��ʣ�ɾ���������ȽϺã�
public class MyHashSet {
    //ע�⣬���������Ҫѡ��һ������
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
                //ע�����remove�Ļ�������object�������int���͵ľ���ɾ��index
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
