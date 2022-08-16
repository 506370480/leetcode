package backTracking;

public class FindTargetSumWays {
    static int ans = 0;
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return ans;
    }
    public static void dfs(int[] nums,int target,int res,int index){
        System.out.println(res+"---"+index);
        if(index==nums.length){
            if(res==target) {
                ans++;
            }
            return;
        }
        dfs(nums,target,res+nums[index],index+1);
        //这个为什么不需要？？？
//        res -= nums[index-1];
//        index--;

        dfs(nums,target,res-nums[index],index+1);
//        res += nums[index-1];
//        index--;
    }
}
