package math;

public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
    public static int trailingZeroes(int n) {
        if(n==0){
            return 0;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while(temp%10==0){
                res +=1;
                temp = temp/10;
            }
            while(temp%5==0){
                res+=1;
                temp/=5;
            }
        }
        return res;
    }

}
