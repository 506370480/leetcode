package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DisruptedArray {
    private int[] nums;
    public static void main(String[] args) {
        DisruptedArray disruptedArray = new DisruptedArray(new int[]{1,2,3});
        int[] param_1 = disruptedArray.reset();
        System.out.println(param_1.toString());
        System.out.println(disruptedArray.shuffle().toString());

    }

    public DisruptedArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        List<Integer> shuffle = new ArrayList<>(nums.length);
        for(int i=0;i<nums.length;i++){
            shuffle.add(null);
        }
        int[] result = new int[nums.length];
        Random r = new Random();
        int random = 0;
        for (int i = 0; i < nums.length; i++) {
            while(shuffle.get(random)!=null){
                random = r.nextInt(nums.length);
            }
            shuffle.set(random,nums[i]);
        }
        //Integer[] integers = shuffle.toArray(new Integer[shuffle.size()]);
        //只能转换成Integer类型的了，否则只能用循环
        for(int i=0;i<nums.length;i++){
            result[i] = shuffle.get(i);
        }
        return result;
    }
}
