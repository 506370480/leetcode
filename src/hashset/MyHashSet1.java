package hashset;

import java.util.ArrayList;
import java.util.Arrays;
//使用二维数组是个糟糕的选择，会超时
public class MyHashSet1 {
    private Integer[][] set = new Integer[100][100];
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public MyHashSet1() {
        this.set = set;
    }

    public void add(int key) {
        int i = key % 100;
        int k = 0;
        while (set[i][k]!=null){
            if(set[i][k].equals(key)){
                return;
            }
            k++;
        }
        set[i][k] = key;
    }

    //如果是数组的话如何remove呢？
    public void remove(int key) {
        int i = key % 100;
        int k = 0;
        while (set[i][k]!=null){
            if(set[i][k].equals(key)){
                set[i][k] = null;
                while(set[i][k+1]!=null&&k+1<100){
                    set[i][k] = set[i][k+1];
                    k++;
                }
                return;
            }
        }
    }

    public boolean contains(int key) {
        int i = key % 100;
        int k = 0;
        while (set[i][k]!=null){
            if(set[i][k].equals(key)){
                return true;
            }
        }
        return false;
    }
}
