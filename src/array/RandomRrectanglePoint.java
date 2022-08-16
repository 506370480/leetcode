package array;

import java.util.Arrays;
import java.util.Random;

public class RandomRrectanglePoint {
    public static void main(String[] args) {
        RandomRrectanglePoint r = new RandomRrectanglePoint(new int[][]{{1,1,5,5}});
        System.out.println(Arrays.toString(r.pick()));

    }

    Random rand = new Random();
    int[] sumPoints;
    int[][] rect;
    public RandomRrectanglePoint(int[][] rects) {
        rect = rects;
        sumPoints = new int[rects.length];
        sumPoints[0] = (rects[0][2]-rects[0][0]+1)*(rects[0][3]-rects[0][1]+1);
        for (int i = 1; i < rects.length; i++) {
            sumPoints[i] = sumPoints[i-1]+(rects[i][2]-rects[i][0]+1)*(rects[i][3]-rects[i][1]+1);
        }

    }

    public int[] pick() {
        int random = rand.nextInt(sumPoints[sumPoints.length - 1]);
        int temp = 0;
        for (int i = 0; i < sumPoints.length; i++) {
            if(random<sumPoints[i]){
                temp = i;
                break;
            }
        }
        int cnt = sumPoints[temp]-random-1;
        int row = rect[temp][2]-(cnt+1)/(rect[temp][3]-rect[temp][1]+1);
        int col = rect[temp][3]-cnt%(rect[temp][2]-rect[temp][0]+1);
        row = rect[temp][2]-rand.nextInt(rect[temp][2]-rect[temp][0]+1);
        col = rect[temp][3]-rand.nextInt(rect[temp][3]-rect[temp][1]+1);
        return new int[]{row,col};
    }
}
