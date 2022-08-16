package other;

import java.util.ArrayList;
import java.util.List;
//�����ĿҲ�����ĺܼ��ѣ���Ϊһֱû�а��պñ߽�����Ӧ�����д��һֱ������Խ���ָ���쳣
//�Լ���һ���ص�ע��ľ��Ǳ߽���������Ӧ�����������Գ����ģ�������Ҫ����һ����λ��
public class YanghuiTriangle {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  list  = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> integerList = new ArrayList<>();
            int j=0;

            integerList.add(1);
            j++;
            while(j<i&&i!=1){
                integerList.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
                j++;
            }
            if(i!=0){
                integerList.add(1);
            }
            list.add(integerList);
        }
        return list;
    }
}
