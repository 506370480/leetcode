package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {1, 3}}));
    }

    //主要想法是按照结束的顺序排序，选择最先结束的那个，给后边尽可能留出空间，得到的就是最优结果
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0||intervals.length==1){
            return 0;
        }

        //第一个问题，如何找到最先结束的那个区间？
        //使用Comparator，这是一个接口，使用的是匿名内部类，直接new 接口名(){重写的函数}
        //“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                //升序
                //o2[1]-o1[1] 就是降序
                return o1[1]-o2[1];

            }
        });

        int count=1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=end){
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;
    }
}
