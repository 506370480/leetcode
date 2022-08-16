package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        merge(new int[][]{{1,4},{2,3}});
    }
    public static int[][] merge(int[][] intervals) {
        //首先是需要排序的
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length-1; i++) {
            while(i<intervals.length-1&&intervals[i][1] >= intervals[i+1][0]){
                end = Math.max(intervals[i][1],intervals[i+1][1]);
                i++;
            }
            if(i!=intervals.length-1){
                list.add(new int[]{start,end});
                start = intervals[i+1][0];
            }
        }
        list.add(new int[]{start,end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
