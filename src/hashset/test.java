package hashset;

import java.util.Iterator;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        MyHashSet1 myHashSet1 = new MyHashSet1();
        myHashSet1.add(1);      // set = [1]
        myHashSet1.add(2);      // set = [1, 2]
        myHashSet1.contains(1); // 返回 True
        myHashSet1.contains(3); // 返回 False ，（未找到）
        myHashSet1.add(2);      // set = [1, 2]
        myHashSet1.contains(2); // 返回 True
        myHashSet1.remove(2);   // set = [1]
        myHashSet1.contains(2); // 返回 False ，（已移除）

    }
}
