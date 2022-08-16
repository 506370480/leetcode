package tree;

public class NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;
        t[2] = 2;
        int trees = trees(t, n);
        return trees;
    }
    public static int trees(int[] t,int n){
        int res = 0;
        if(t[n]!=0){
            return t[n];
        }
        for (int i = 1; i <= n; i++) {
            res+=trees(t,n-i)*trees(t,i-1);
        }
        t[n] = res;
        return res;
    }
}
