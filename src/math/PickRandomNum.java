package math;

import java.util.*;

public class PickRandomNum {
    public static void main(String[] args) {
        PickRandomNum p = new PickRandomNum(new int[]{1, 2, 3, 3, 3});
        System.out.println(p.pick(3));
        System.out.println(p.pick(1));
        System.out.println(p.pick(3));
    }
    int[] nums;
    Random random = new Random();
    Map<Integer, List<Integer>> map = new HashMap<>();
    public PickRandomNum(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.getOrDefault(target, new ArrayList<>());
        return list.get(random.nextInt(list.size()));
    }


    public int pick1(int target){
        int n = nums.length;
        int ans = 0;
        for (int i = 0,cnt=0; i < n; i++) {
            if(nums[i]==target){
                cnt++;
                if(random.nextInt(cnt)==0){
                    ans = i;
                }
            }
        }
        return ans;
    }
}

