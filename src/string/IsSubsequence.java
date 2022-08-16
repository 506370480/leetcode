package string;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "adbddc"));
    }
    //看的答案，利用双指针，想不到
    public static boolean isSubsequence(String s, String t) {
        int j=0;
        for (int i = 0; i < s.length()&&j<t.length();) {
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
            if(i==s.length()){
                return true;
            }
        }
        return false;
    }
}
