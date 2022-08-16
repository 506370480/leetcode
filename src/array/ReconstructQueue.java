package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {
    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }

    public static int[][] reconstructQueue1(int[][] people) {
        int[][] res = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        res[0]=people[0];
        for (int i = 1; i < people.length ; i++) {
            List<int[]> list = new LinkedList<>();
            for (int j = i; j < people.length ; j++) {
                if(people[i-1][0]>=people[j][0]&&people[i-1][0]==(people[j][0]+1)||(people[i-1][0]<people[j][0]&&people[i-1][0]==(people[j][0]))){
                    res[i] = people[j];
                }
            }
        }
        return res;
    }

    //只要先确定好了高个的顺序，矮个随便怎么插都不会对已经插好的高个有影响了
    public static int[][] reconstructQueue(int[][] people){
        List<int[]> list = new LinkedList<>();
        int[][] res = new int[people.length][people.length];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        list.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
        for (int i = 0; i < people.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
