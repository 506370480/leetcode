package string;

public class StringMulitply {
    public static void main(String[] args) {
        //System.out.println(addString("99", "1"));
        System.out.println(multiply2("123456789", "987654321"));
    }
    public static String multiply(String num1, String num2) {
        int intNum1 = 0;
        int intNum2 = 0;
        //不能使用内置函数转换为整数
        int len1 = num1.length();
        int len2 = num2.length();

        for (int i = 0; i < len1; i++) {
            intNum1 *= 10;
            intNum1 += num1.charAt(i)-'0';
        }

        for (int i = 0; i < len2; i++) {
            intNum2 *= 10;
            intNum2 += num2.charAt(i)-'0';
        }
        return String.valueOf(intNum1 * intNum2);
    }

    //按位实现乘法
    //需要m*n次乘法
    //只允许个位数的乘法，只允许用个位数的加法，否则即使使用long也会超出边界
    public static String multiply1(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        long res = 0;

        for (int i = 0; i < len1; i++) {
            int num = num1.charAt(i)-'0';
            long sum = 0;
            int rem = 0;
            long pow = 1;
            for (int j = len2-1; j >= 0; j--) {
                sum += (((num2.charAt(j)-'0')*num+rem)%10)*pow;
                 rem = ((num2.charAt(j)-'0')*num+rem)/10;
                 pow*=10;
            }
            if(rem!=0){
                sum = rem*pow+sum;
            }
            res = res*10+sum;
        }

        return String.valueOf(res);
    }

    public static String multiply2(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        String res = "";

        for (int i = 0; i < len1; i++) {
            StringBuffer sb = new StringBuffer();
            int num = num1.charAt(i)-'0';
            String sum = null;
            int rem = 0;
            for (int j = len2-1; j >= 0; j--) {
                sb.append(((num2.charAt(j)-'0')*num+rem)%10);
                rem = ((num2.charAt(j)-'0')*num+rem)/10;
            }
            if(rem!=0){
                sb.append(rem);
            }
            res = addString(res,sb.append(0).toString());
        }
        return res;
    }


    //子方法，两个字符串中的数字相加
    public static String addString(String num1,String num2){
        StringBuffer sb = new StringBuffer();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        if(num1.length()<num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int rem = 0;
        int i = 0;
        for (; i <num2.length() ; i++) {
            sb.append((num1.charAt(i)-'0'+num2.charAt(i)-'0'+rem)%10);
            rem = (num1.charAt(i)-'0'+num2.charAt(i)-'0'+rem)/10;
        }
        while(i<num1.length()){
            sb.append((num1.charAt(i)-'0'+rem)%10);
            rem = (num1.charAt(i)-'0'+rem)/10;
            i++;
        }
        if(rem!=0){
            sb.append(rem);
        }
        return sb.reverse().toString();
    }
}
