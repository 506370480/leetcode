package math;

//不使用循环或者递归来完成本题
public class isPowerOfThree {
    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree2(9);
        System.out.println(powerOfThree);
    }

    //这个是自己写的，感觉可以了
    public static boolean isPowerOfThree(int n) {
        while (n != 3) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return true;
    }

    //1.这个和自己的思路是一样的，但是别人家的代码好简洁呀
    public static boolean isPowerOfThree1(int n){
        if(n>1){
            while(n%3==0){
                n/=3;
            }
        }
        return n==1;
    }

    //2.递归
    public static boolean isPowerOfThree2(int n){
        if(n<=0){
            return false;
        }
        if(n==1){
            //这个是边界条件
            return true;
        }
        if(n%3==0&&isPowerOfThree(n/3)){
            return true;
        }
        return false;
    }
}
