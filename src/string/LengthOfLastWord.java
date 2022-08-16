package string;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord1("   asdf         asdf   "));
    }
    public static int lengthOfLastWord(String s) {
        int l = -1,r = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)!=' '){
                r = i;
                break;
            }
        }
        for (int i = r; i >=0 ; i--) {
            if(s.charAt(i)==' '){
                l = i;
                break;
            }
        }
        return r-l;
    }

    public static int lengthOfLastWord1(String s){
        int index = s.length()-1;
        while (s.charAt(index)==' '){
            index--;
        }
        int sum = 0;
        while(index>=0&&s.charAt(index)!=' '){
            index--;
            sum++;
        }
        return sum;
    }
}
