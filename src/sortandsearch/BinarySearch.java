package sortandsearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    //发现自己二分搜索不会写，特来学习
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums.length==0){
            return -1;
        }
        while(low<=high){
            if(nums[(low+high)/2]==target){
                return (low+high)/2;
            }
            if(nums[(low+high)/2]>target){
                high = (low+high)/2-1 ;
            }else{
                low = (low+high)/2+1;
            }
        }
        return -1;
    }
}
