package backTracking;

import java.util.*;

public class CombinationSum {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> t = new LinkedList<>();
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        System.out.println(combinationSum(candidates,8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return res;
    }
    public static void dfs(int[] condidates,int n,int result){
        System.out.println(t+"---"+result);
        if(result==n){
            List s = new LinkedList(t);
            Collections.sort(s);
            if(!res.contains(s)) {
                res.add(new LinkedList<>(s));
            }
            return;
        }
        if(result>n){
            return;
        }
        for (int condidate : condidates) {
            t.add(condidate);
            dfs(condidates,n,result+condidate);
            t.remove(t.size()-1);
        }
    }
}
