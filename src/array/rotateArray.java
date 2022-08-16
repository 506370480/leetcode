package array;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class rotateArray {
    public void rotate(int[] nums, int k) {
        //旋转数组
        int length = nums.length;
        k %= length;
        //上边这两行是必要的，不然k>length的时候就会出错
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
    }
}
