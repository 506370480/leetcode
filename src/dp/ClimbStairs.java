package dp;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(c(6));
    }

    //动态规划 完全没思路。。。
    //看了一点题解，明白了，当n=1的时候只有一种方法，n=2的时候有2种
    //n=3的时候有3种，从1级台阶跳两个上去，或者从2级台阶跳一个上去，就是f(3)=f(1)+f(2)
    //以此类推，f(4)=f(3)+f(2) f(5)=f(4)+f(3) f(6)=f(f)+f(4)以此类推
    //这个递归确实对，但是超出了时间限制，需要使用记忆化搜索
    //不能再递归的方法中去新建数组之类的，必须使用另外的方法调用这个方法，以下两个方法组合使用
    public static int c(int n){
        int[] stairs = new int[n];
        return climbStairs(n,stairs);
    }
    public static int climbStairs(int n,int[] stairs) {
        //不能再递归体里边定义递归，因为会重复的新建
        //int[] stairs = new int[n];
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(stairs[n-1]!=0){
            return stairs[n-1];
        }else {
            stairs[n-1] = climbStairs(n - 1,stairs) + climbStairs(n - 2,stairs);
            return stairs[n-1];
        }
    }


    //现现在开始迭代方法-自底向上
    public static int climbStairs(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        if(n>1){
            dp[2]=2;
        }
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
