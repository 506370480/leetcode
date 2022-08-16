package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges1(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                buffer.append("->");
                buffer.append(nums[i]);
            } else {
                if (buffer.length() > 1) {
                    buffer.delete(buffer.indexOf(">") + 1, buffer.length());
                    buffer.append(nums[i - 1]);
                }
                res.add(buffer.toString());
                buffer.delete(0, buffer.length());
                buffer.append(nums[i]);
            }
        }
        if (buffer.length() > 1 && buffer.charAt(buffer.length() - 1) - '0' == nums[nums.length - 1]) {
            buffer.delete(buffer.indexOf(">") + 1, buffer.length());
            buffer.append(nums[nums.length - 1]);
        }
        res.add(buffer.toString());
        return res;
    }

    public static List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while(i<n&&nums[i]== nums[i-1]+1){
                i++;
            }
            int high = i-1;
            StringBuffer buffer = new StringBuffer();
            buffer.append(nums[low]);
            if(low < high){
                buffer.append("->");
                buffer.append(nums[high]);
            }
            res.add(buffer.toString());
        }
        return res;
    }
}
