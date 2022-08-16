package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> t = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        backTrack(0,nums);
        return res;
    }
    public static void backTrack(int cur,int[] nums){
        if(cur == nums.length){
            res.add(new LinkedList<>(t));
            return;
        }
        t.add(nums[cur]);
        backTrack(cur+1,nums);
        t.remove(t.size()-1);

        backTrack(cur+1,nums);
    }
}
