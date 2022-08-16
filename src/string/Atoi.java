package string;
//这道题写了很久很久，主要因素是没有考虑到指针越界的异常，没有考虑到各种的逻辑之间的关系
//还有各种细节，越加越多，这个需要好好的总结
//而且判断int越界的逻辑也需要学习
public class Atoi {
    public static void main(String[] args) {
        myAtoi("  -0012a42");
        System.out.println(myAtoi("   -42"));
    }


    public static int myAtoi(String s) {
        //1.去除前导空格
        int index = 0;
        for (; index < s.length(); index++) {
            if (s.charAt(index) != ' ') {
                break;
            }
        }
        if (index >= s.length()) {
            return 0;
        }
        int flag = 1;
        if (s.charAt(index) == '-') {
            flag = -1;
            index++;
            if (index >= s.length()) {
                return 0;
            }
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return 0;
            }
        }
        if (s.charAt(index)  ==     '+') {
            index++;
            if (index >= s.length()) {
                return 0;
            }
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return 0;
            }
        }
        //int start = index;
        int temp = 0;
        int result = 0;
        for (; index < s.length(); index++) {
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return result;
            }
            while (s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9) {
                //这个是抄的别人的代码，判断是否越界的操作，可以学习记忆
                temp = result;
                result = result * 10 + (s.charAt(index) - '0');
                //越界了
                if (result / 10 != temp) {
                    if (flag > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                index++;
                if (index >= s.length()) {
                    break;
                }
                if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                    return result*flag;
                }
            }
        }
        return result*flag;
//        if (start == index) {
//            return 0;
//        }

        //这里不能直接使用parseint，因为会有超过最大值的值，就会失效。
        //int num = Integer.parseInt(s.substring(start, index));
        //return num * flag;
    }
}
