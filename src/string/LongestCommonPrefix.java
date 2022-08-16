package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //���ǰ׺��û˼·
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i<strs.length){
            while(strs[i].indexOf(pre)!=0){
                //substring ���ұ�
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
