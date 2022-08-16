package hashset;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-1, 2}, new int[]{0, 2}, new int[]{-2, -1}));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int len = nums1.length;
        if (len == 0) {
            return 0;
        }
        Map<Integer, Integer> hashmap1 = new HashMap<>();
        Map<Integer, Integer> hashmap2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                hashmap1.put(nums1[i] + nums2[j], hashmap1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                hashmap2.put(nums3[i] + nums4[j], hashmap2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }
        int count = 0;
        for (Integer integer : hashmap1.keySet()) {
            if (hashmap2.containsKey(-integer)) {
                count += hashmap1.get(integer) * hashmap2.get(-integer);
            }
        }
        return count;
    }
}
