package string;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'H','0'};

        //下边是初始化字符数组的三种方式
        //1.这个是第一种方式，不指定个数
        char a[]={'1','2','3'};//可以不指定char类型的个数，
        //推荐使用下边这种
        char[] b={'1','2','3'};
        //或者使用这种
        char[] c=new char[]{'1','2','3'};
        char[] d=new char[3];
        d[0]='1';
        d[1]='2';
        d[2]='3';

        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        if(s.length==0){
            return;
        }
        for(int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }


    }
}
