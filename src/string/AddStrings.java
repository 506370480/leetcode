package string;
//大数相加，用parseInt是会越界的
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("91", "9"));
    }
    public static String addStrings1(String num1, String num2) {
        int add = 0;
        String res = "";
        if(num1.length()>num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int len = num2.length()-num1.length();
        for (int i = 0; i <len ; i++) {
            num1 = '0'+num1;
        }
        for (int i = num1.length()-1; i >=0; i--) {
            res = (num1.charAt(i)-'0'+(int)num2.charAt(i)-'0'+add)%10+res;
            if(((int)num1.charAt(i)-'0'+(int)num2.charAt(i)-'0'+add)>9){
                add = 1;
            }else{
                add = 0;
            }
            if(i==0&&add==1){
                res = '1'+res;
            }
        }
        return res;
    }

    public static String addStrings(String num1, String num2){
        StringBuffer res = new StringBuffer();
        int i = num1.length()-1,j = num2.length()-1,add = 0;
        while(i>=0||j>=0||add!=0){
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            int result = x+y+add;
            res.append(result%10);
            add = result/10;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();

    }
}
