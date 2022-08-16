package array;
//这个题有两个要点
//1.快慢指针都要使用long，因为快慢指针平方的和可能会超过int的范围
//2.先判断是否是大于c,大于的话fast--，这样就能保证双指针是一定正确的
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum1(1000));
    }
    public static boolean judgeSquareSum1(int c) {
        int slow = 0;
        int fast = (int)Math.sqrt(c);
        while(fast*fast+slow*slow!=c){
            if(fast*fast+slow*slow<c){
                slow++;
            }else{
                fast--;
            }
            if(fast<slow){
                return false;
            }
        }
        return true;
    }
    public static boolean judgeSquareSum(int c) {
        long slow = 0;
        long fast = (long)Math.sqrt(c);
        while(fast*fast+slow*slow!=c){
            if(fast*fast+slow*slow>c){
                fast--;
            }else{
                slow++;
            }
            if(fast<slow){
                return false;
            }
        }
        return true;
    }
}

