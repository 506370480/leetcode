package array;

public class SearchRange {
    public static void main(String[] args) {
        searchRange1(new int[]{5,7,7,8,8,10},8);
    }

    //要求是o(logn),先来个o(n)试试手,超过了10.8%的
    public static int[] searchRange(int[] nums, int target) {
        int high = -1;
        int low = -1;
        if(nums.length==0){
            return new int[]{low,high};
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                low=i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[nums.length-i-1]==target){
                high=nums.length-i-1;
                break;
            }
        }
        return new int[]{low,high};
    }

    //使用二叉查找，应该就是o(logn)了
    public static int[] searchRange1(int[] nums, int target){
        int low = -1;
        int high = -1;
        if(nums.length==0){
            return new int[]{low,high};
        }
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            if((nums[(i+j)/2]==target&&(i+j)/2==0)||(nums[(i+j)/2]==target&&nums[(i+j)/2-1]!=target)){
                low = (i+j)/2;
                break;
            }
            if(nums[(i+j)/2]>=target){
                j = (i+j)/2-1;
            }else{
                i = (i+j)/2+1;
            }
        }

        i = 0;
        j = nums.length-1;
        while(i<=j){
            if((nums[(i+j)/2]==target&&(i+j)/2==nums.length-1)||(nums[(i+j)/2]==target&&nums[(i+j)/2+1]!=target)){
                high = (i+j)/2;
                break;
            }
            if(nums[(i+j)/2]>target){
                j = (i+j)/2-1;
            }else{
                i = (i+j)/2+1;
            }
        }
        return new int[]{low,high};
    }
}
