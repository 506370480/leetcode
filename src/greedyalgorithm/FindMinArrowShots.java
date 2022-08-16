package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
    //总体想法是按照右边界排序，然后每次必须有一个射向右边界最靠左的那一个
    //
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        if(points.length==1){
            return 1;
        }
        Integer[] res = new Integer[points.length];
        res[0] = 1;
        int end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if(res[i]==null){
                res[i]=1;
            }
            if(res[i]==0){
                continue;
            }
            for(int j = i+1; j< points.length;j++){
                if(points[i][1]>=points[j][0]){
                    res[j] = 0;
                }
            }
        }
        int count = 0;
        for(int i = 0;i< points.length;i++){
            if(res[i]==1){
                count++;
            }
        }
        return count;
    }

    //自己写的过于复杂了，现在借鉴其他人的代码
    public static int findMinArrowShots1(int[][] points){
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        if(points.length==1){
            return 1;
        }

        //下边是其他人的代码
        //慢慢学习
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
