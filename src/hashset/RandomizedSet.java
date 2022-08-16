package hashset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
RandomizedSet() ��ʼ�� RandomizedSet ����
bool insert(int val) ��Ԫ�� val ������ʱ���򼯺��в����������� true �����򣬷��� false ��
bool remove(int val) ��Ԫ�� val ����ʱ���Ӽ������Ƴ���������� true �����򣬷��� false ��
int getRandom() ����������м����е�һ�����������֤���ô˷���ʱ���������ٴ���һ��Ԫ�أ���ÿ��Ԫ��Ӧ���� ��ͬ�ĸ��� �����ء�
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
