package math;
//位运算很巧妙，可惜我不会
//https://leetcode.cn/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
    public static boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        while(n>1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;
    }
}
