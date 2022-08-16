package greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//此题未完成
public class Merge {
    public static void main(String[] args) {

    }

    //按右端排序
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                end = intervals[i][1];
            }else{
                list.add(new int[]{start,end});
            }
        }
        return null;
    }
}
