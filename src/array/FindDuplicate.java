package array;

public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast!= slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
