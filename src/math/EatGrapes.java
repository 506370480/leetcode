package math;

import java.util.Scanner;
public class EatGrapes {
    public static void main(String[] args) {
        int n = 0;
        long[] nums = new long[3];
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int res = 0;
            long min = Integer.MAX_VALUE;
            long max = Integer.MIN_VALUE;
            for (int j = 0; j < 3; j++) {
                nums[j] = in.nextInt();
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
            }
            res += min%2==0?min:min-1;
            res+=(max-res)/2==0?(max-res)/2:(max-res+1)/2;
            System.out.println(res);
        }
    }
}