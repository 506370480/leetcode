package array;

public class FindPoisonedDuration {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 3, 4}, 2));
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for(int i = 1;i<timeSeries.length;i++){
            res = res+(timeSeries[i]-timeSeries[i-1]>=duration?duration:timeSeries[i]-timeSeries[i-1]);
        }
        res+=duration;
        return timeSeries.length==0?0:res;
    }
}
