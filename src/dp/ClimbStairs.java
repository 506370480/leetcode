package dp;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(c(6));
    }

    //��̬�滮 ��ȫû˼·������
    //����һ����⣬�����ˣ���n=1��ʱ��ֻ��һ�ַ�����n=2��ʱ����2��
    //n=3��ʱ����3�֣���1��̨����������ȥ�����ߴ�2��̨����һ����ȥ������f(3)=f(1)+f(2)
    //�Դ����ƣ�f(4)=f(3)+f(2) f(5)=f(4)+f(3) f(6)=f(f)+f(4)�Դ�����
    //����ݹ�ȷʵ�ԣ����ǳ�����ʱ�����ƣ���Ҫʹ�ü��仯����
    //�����ٵݹ�ķ�����ȥ�½�����֮��ģ�����ʹ������ķ�������������������������������ʹ��
    public static int c(int n){
        int[] stairs = new int[n];
        return climbStairs(n,stairs);
    }
    public static int climbStairs(int n,int[] stairs) {
        //�����ٵݹ�����߶���ݹ飬��Ϊ���ظ����½�
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


    //�����ڿ�ʼ��������-�Ե�����
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
