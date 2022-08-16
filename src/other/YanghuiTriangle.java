package other;

import java.util.ArrayList;
import java.util.List;
//这个题目也是做的很艰难，因为一直没有把握好边界条件应该如何写，一直是数组越界的指针异常
//自己下一步重点注意的就是边界条件，不应该再是那种试出来的，而是需要尽量一步到位。
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
