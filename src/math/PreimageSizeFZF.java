package math;

public class PreimageSizeFZF {
    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(3));
    }
    //遍历超时，想到使用二分搜索
    //需要二分搜索两个值，感觉可以分成两次进行
    public static int preimageSizeFZF(int k) {
        int i=0,j=0;
        int low = 0,high = (int)Math.pow(5,k),mid = (low+high)/2;
        while(low<=high){
            if(trailingZeroes(mid)==k&&trailingZeroes(mid-1)<k){
                i = mid;
                break;
            }else if(trailingZeroes(mid)>=k){
                high = mid-1;
                mid = (low+high)/2;
            }else{
                low = mid+1;
                mid = (low+high)/2;
            }
        }
        low = 0;
        high = (int)Math.pow(5,k);
        mid = (low+high)/2;
        while(low<=high){
            if(trailingZeroes(mid)==k&&trailingZeroes(mid+1)>k){
                j = mid;
                break;
            }else if(trailingZeroes(mid)>k){
                high = mid-1;
                mid = (low+high)/2;
            }else{
                low = mid+1;
                mid = (low+high)/2;
            }
        }
        return j-i+1;


    }
    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int temp = i; temp % 5 == 0; temp /= 5) {
                ans++;
            }
        }
        return ans;
    }
}
