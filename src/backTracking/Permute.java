package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    static List<List<Integer>> res = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }


    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;
    }
    public static void backTrack (int[] nums,LinkedList<Integer> track){
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track);
            track.removeLast();
        }

    }
}
