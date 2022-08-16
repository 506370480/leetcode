package array;

import java.util.Arrays;

public class RotateArraySearch {
    public static void main(String[] args) {
        System.out.println(search1(new int[]{3,5,1},3));
    }
    //o(logn)时间复杂度
    //1.先反转过来
    //2.再二分查找
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        int res = -1;
        if(nums.length==1&&nums[0]!=target){
            return -1;
        }
        if(nums.length==1&&nums[0]==target){
            return 0;
        }
        while(low<=high){
            mid = (low+high)/2;
            if(mid==0||mid==nums.length-1||nums[mid]>nums[mid+1]){
                res = mid;
                break;
            }
            if(nums[mid]>nums[0]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        if(target>nums[nums.length-1]||res==nums.length-1){
            low = 0;
            high = res;
        }else{
            low = res+1;
            high = nums.length-1;
        }

        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid, res = 0;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (low <= high) {
            mid = low + ((high-low) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            if (mid!=0&&nums[mid] < nums[mid - 1]) {
                res = mid;
                break;
            } else if (nums[mid] < nums[0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        nums = reverseArray(nums,0,res-1);
        nums = reverseArray(nums,res,nums.length-1);
        nums = reverseArray(nums,0,nums.length-1);

        low = 0;
        high = nums.length-1;
        int result = -1;
        while (low <= high) {
            mid = low+((high - low)>>1);
            if(nums[mid]==target){
                result = mid;
                break;
            }
            if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        if(result == -1){
            return -1;
        }

        return result<=res?(result+res)% nums.length:(result+nums.length-res+1)%nums.length;

    }


    public static int[] reverseArray(int[] nums,int l,int r){
        for (int i = 0; i < (r - l + 1) / 2; i++) {
            int temp = nums[l+i];
            nums[l+i] = nums[r-i];
            nums[r-i] = temp;
        }
        return nums;
    }
}
