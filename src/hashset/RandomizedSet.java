package hashset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
RandomizedSet() 初始化 RandomizedSet 对象
bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 */
class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet ranset = new RandomizedSet();
        ranset.insert(1);
        ranset.insert(20);
        ranset.insert(10);
        ranset.insert(30);
        System.out.println(ranset.getRandom());
        System.out.println(ranset.getRandom());
        System.out.println(ranset.getRandom());
        System.out.println(ranset.getRandom());
    }



    private Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        boolean add = set.add(val);
        return add;
    }

    public boolean remove(int val) {
        if(!set.contains(val)){
            return false;
        }
        boolean remove = set.remove(val);
        return remove;
    }

    public int getRandom() {
        int size = set.size();
        int i = 0;
        int random = (int) (Math.random() * size);
        for (Integer integer : set) {
            if(random==i){
                return integer;
            }
            i++;
        }
        return 0;
    }
}
