package array;

public class ProductExceptSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[]{-1,1,0,-3,3});
    }
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            product = product*=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                ans[i] = product/nums[i];
            }else{
                int tmp = 1;
                for (int j = 0; j < nums.length; j++) {
                    if(i!=j){
                        tmp*=nums[j];
                    }
                }
                ans[i] = tmp;
            }
        }
        return ans;
    }
}
