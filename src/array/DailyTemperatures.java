package array;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int tmp = 1;
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[j]>temperatures[i]){
                    break;
                }
                tmp++;
            }
            if(tmp == temperatures.length-i){
                res[i]=0;
            }else {
                res[i] = tmp;
            }
        }
        return res;
    }

    //使用最小栈
    public static int[] dailyTemperatures(int[] temperatures){
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
