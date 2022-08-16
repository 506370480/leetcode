package math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNum {
    public static void main(String[] args) {
        int i = countPrimes1(10);
        System.out.println(i);
    }
    //1.用筛选法，但是如果只是用双重循环去筛选的话时间复杂度和直接求是差不多的。
    //2.改进一点就是在第二重循环的时候，设置j+=i
    //3.但是不能直接删除数据，这样会导致后续的j+=i的次序是混乱的。
    public static int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        for (int i = 2; i < list.size(); i++) {
            Integer integer = list.get(i);
            for (int j = i; j < list.size(); j+=i) {
                Integer integer1 =  list.get(j);
                if(integer1%integer==0&&list.get(i)!=list.get(j)){
                    list.remove(integer1);
                }
            }
        }
        return list.size();

    }

    public static int countPrimes1(int n){
        if (n == 0 || n == 1) {
            return 0;
        }
        //
        //boolean是基本数据类型,初值为false
        //Boolean是它的封装类，和其他类一样，有属性有方法，可以new,是null,既不是0也不是1
        boolean[] arr=new boolean[n];
        int count=0;
        for (int i=2;i<n;i++){
            if(arr[i]){
                continue;
            }
            count++;
            for(int j=i;j<n;j+=i){
                arr[j]=true;
            }
        }
        return count;
    }
}
