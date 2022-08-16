package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMoves {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 3}));
    }
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if(min==max){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            res+=nums[i]-min;
        }
        return res;
    }
}
