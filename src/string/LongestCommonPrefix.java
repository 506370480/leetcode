package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //求最长前缀，没思路
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i<strs.length){
            while(strs[i].indexOf(pre)!=0){
                //substring 左开右闭
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
