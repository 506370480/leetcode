package array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
    //Ñ­»·Êý×é
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n*2-1; i >=0  ; i--) {
            while (!stack.isEmpty()&&nums[i%n]>=nums[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                res[i%n] = nums[stack.peek()];
            }
            stack.push(i % n);
        }
        return res;
    }
}
