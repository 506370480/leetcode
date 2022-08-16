package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement1(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0;
        for (int k=0;k<nums1.length;k++) {
            for (; i < nums2.length; i++) {
                if(nums1[k] == nums2[i]){
                    nums1[k] = i;
                    i=0;
                    break;
                }
            }
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        for (int j = 0; j < nums1.length; j++) {
            for (int k = nums1[j]; k < nums2.length; k++) {
                if(nums2[nums1[j]]< nums2[k]){
                    res[j] = nums2[k];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2){
        //单调栈
        //分为两个步骤
        //1.找到nums2里每个元素右边比它大的元素所在的位置，并用map记录
        //2.遍历nums1取出来
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = nums2.length-1; i >=0 ; i--) {
            while(!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],nums2[stack.peek()]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}
