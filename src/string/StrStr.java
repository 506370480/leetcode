package string;

public class StrStr {
    public static void main(String[] args) {
        int i = strStr1("mississippi", "issipi");
        System.out.println(i);
    }

    //这个是我自己的方法，两个循环，感觉脑子好混乱，到处都是很多没有考虑的情况，结果就是自己一直在原来的代码上修修补补的，不断地debug才能发现到底是哪里出错了

    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        for(int i=0;i<haystack.length();){
            for(int j=0;j<needle.length();){
                if(haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    j++;
                }else {
                    i=i-j+1;
                    j=0;
                    break;
                }
                if(j==needle.length()){
                    return i-needle.length();
                }
                if(i==haystack.length()){
                    return -1;
                }
            }
        }
        return -1;

    }

    //下边这个是其他人的方法，没必要用两个循环，而且可以提前考虑指针越界的情况。
    public static int strStr1(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
       int i=0;
        int j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
            if(j==needle.length()){
                return i-j;
            }
        }
        return -1;

    }
}
