package array;

import java.util.Arrays;
import java.util.Stack;

public class FinalPrices {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{10,1,1,6})));
    }
    //找到后边第一个比自身小的元素
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        int n = prices.length;
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty()&&prices[i] < prices[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = prices[i]-prices[stack.peek()];
            }else{
                result[i] = prices[i];
            }
            stack.push(i);
        }
        return result;
    }
}
