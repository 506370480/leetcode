package other;

import java.util.ArrayList;
import java.util.List;
//注意remove,如果里边是数字，就是index,如果里边是object,就是删除特定的object
//如果想要删除特定的数字，就需要使用（Integer）来转换成包装类


//length ：Arrays （int[]， double[]， String[]） — 取得Array的长度
//length（）：String related Object （String， StringBuilder， etc） — 取得字符串的长度
//size（）：Collection Object （ArrayList， Set， etc） — 取得集合的大小
public class MissingNumber {
    public static void main(String[] args) {
        int i = missingNumber3(new int[]{3, 0, 1});
        System.out.println(i);
    }

    //遍历添加数字，遍历删除数字，时间复杂度很高
    public static int missingNumber(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=length;i++){
            list.add(i);
        }
        for(int i=0;i<length;i++){
            list.remove((Integer) nums[i]);
        }
        return list.get(0);
    }

    //求和相减,很简洁也很巧妙
    public static int missingNumber2(int[] nums){
        int sum=0;
        int n = nums.length;
        for(int i:nums){
            sum+=i;
        }
        return n*(n+1)/2-sum;
    }

    //使用异或求解，异或求解重复数字的问题很简单
    //a^a=0；自己和自己异或等于0
    //a^0=a；任何数字和0异或还等于他自己
    //a^b^c=a^c^b；异或运算具有交换律
    public static int missingNumber3(int[] nums){
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i]^(i+1);
        }
        return xor;
    }
}
