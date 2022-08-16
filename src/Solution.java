import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length-set.size()];
        int index = 0;
        for(int i=1;i<=nums.length;i++){
            if(set.contains(i)){
                continue;
            }
            list.add(i);
            res[index] = i;
            index++;
        }
        return list;
    }
}