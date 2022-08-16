package math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNum {
    public static void main(String[] args) {
        int i = countPrimes1(10);
        System.out.println(i);
    }
    //1.��ɸѡ�����������ֻ����˫��ѭ��ȥɸѡ�Ļ�ʱ�临�ӶȺ�ֱ�����ǲ��ġ�
    //2.�Ľ�һ������ڵڶ���ѭ����ʱ������j+=i
    //3.���ǲ���ֱ��ɾ�����ݣ������ᵼ�º�����j+=i�Ĵ����ǻ��ҵġ�
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
        //boolean�ǻ�����������,��ֵΪfalse
        //Boolean�����ķ�װ�࣬��������һ�����������з���������new,��null,�Ȳ���0Ҳ����1
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
