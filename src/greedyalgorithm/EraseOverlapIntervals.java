package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {1, 3}}));
    }

    //��Ҫ�뷨�ǰ��ս�����˳������ѡ�����Ƚ������Ǹ�������߾����������ռ䣬�õ��ľ������Ž��
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0||intervals.length==1){
            return 0;
        }

        //��һ�����⣬����ҵ����Ƚ������Ǹ����䣿
        //ʹ��Comparator������һ���ӿڣ�ʹ�õ��������ڲ��ֱ࣬��new �ӿ���(){��д�ĺ���}
        //���Ƚ�x��y�Ĵ�С���������ء�����������ζ�š�x��yС�������ء��㡱����ζ�š�x����y�������ء�����������ζ�š�x����y����
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                //����
                //o2[1]-o1[1] ���ǽ���
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
