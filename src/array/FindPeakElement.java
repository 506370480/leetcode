package array;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,3,2,1}));
    }
    //严格大于左右相邻值，二分
    public static int findPeakElement(int[] nums) {
        if(nums.length <=1||nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int l=0,r=nums.length-1;
        int mid = l+(r-l)/2;
        while (l<r){
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid-1]<nums[mid]){
                l = mid;
                mid = l+(r-l)/2;
            }else{
                r = mid;
                mid = l+(r-l)/2;
            }
        }
        return 0;
    }
}
