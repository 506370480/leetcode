package math;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2}, new int[]{2,1}));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int[] preSum = new int[gas.length];
        diff[0] = gas[0] - cost[0];
        preSum[0] = diff[0];
        int min = preSum[0];
        for (int i = 1; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            preSum[i] = diff[i]+preSum[i-1];
            min = Math.min(preSum[i], min);
        }
        if(preSum[gas.length-1]<0){
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            if(preSum[i] == min){
                return (i+1)%gas.length;
            }
        }
        return 0;
    }
}
