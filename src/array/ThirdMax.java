package array;

import java.util.Arrays;
import java.util.TreeSet;

public class ThirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax2(new int[]{1, 2, 2, 3}));
    }

    //排序 o(nlogn)
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1 && nums[i] != nums[i + 1]) {
                index++;
            }
            if (index == 3) {
                return nums[i];
            }
        }
        if (index <= 2) {
            return nums[nums.length - 1];
        }
        return 0;
    }

    //有序集合 o(n)
    public static int thirdMax1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }

    //维护三个指针，分别指向最小的值
    public static int thirdMax2(int[] nums) {
        Integer a = null,b=null,c=null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null?a:c;
    }
}
