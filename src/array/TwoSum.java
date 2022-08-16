package array;

public class TwoSum {
    public static void main(String[] args) {
        twoSum(new int[]{1,2,3,5,7},9);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int slow = 0;
        int fast = numbers.length-1;
        while (numbers[slow]+numbers[fast]!=target){
            if(numbers[slow]+numbers[fast]<target){
                slow++;
            }else{
                fast--;
            }
        }
        return new int[]{slow,fast};
    }
}
