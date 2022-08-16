package array;

import java.lang.reflect.Array;
import java.util.*;

public class YanghuiTriangleII {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(getRow(10));
    }
    public static List<Integer> getRow(int rowIndex) {
        map.put(0, new ArrayList<>(Arrays.asList(1)));
        if(map.containsKey(rowIndex)){
            return map.get(rowIndex);
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 0;i<rowIndex-1;i++){
            list.add(getRow(rowIndex-1).get(i)+getRow(rowIndex-1).get(i+1));
        }
        list.add(1);
        map.put(rowIndex,list);
        return list;
    }
}
