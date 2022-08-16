package string;
/*
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
* */

//注意这里的32位不是说一共是32位的数字（
//而是指的是-2,147,483,648 --2,147,483,647之间的数字才属于32位
//Math.abs(-2147483648)=-2147483648（java中的一个小问题）因为正数最大只有2的31次方减一


import java.util.ArrayList;
import java.util.List;

public class IntegerInversion {
    //1.使用int[] s = new int[32];会出现NumberFormatException这个异常，超出了int的范围
    //2.int类型存储范围是-2,147,483,648 --2,147,483,647。最后的结果是不能使用int的
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse2(int x){
        if(x==0||x==Integer.MIN_VALUE){
            return 0;
        }
        //这里是参考其他人的代码
        int flag = x>0 ? 1:-1;
        x=Math.abs(x);

        //将数字转字符串后与最大值进行比较（长度相同且最大位置更大）
        //1、StringBuffer 与 StringBuilder 中的方法和功能完全是等价的，
        //2、只是StringBuffer 中的方法大都采用了 synchronized 关键字进行修饰，因此是线程安全的，
        //而 StringBuilder 没有这个修饰，可以被认为是线程不安全的。
        //3、在单线程程序下，StringBuilder效率更快，因为它不需要加锁，不具备多线程安全
        //而StringBuffer则每次都需要判断锁，效率相对更低(单线程环境下synchronized会发生锁的偏向，并没有锁的竞争情况，偏向锁性能较好)
        String s = new StringBuffer(String.valueOf(x)).reverse().toString();
        String maxLength = String.valueOf(Integer.MIN_VALUE);
        if(s.length()>=maxLength.length()&&s.compareTo(maxLength)>0){
            return 0;
        }else {
            return Integer.valueOf(s)*flag;
        }
    }
    public static int reverse(int x) {
        //下边是自己手写的代码，很多代码太乱了，不简洁
        List<Integer> list = new ArrayList<>();
        int flag= 1;
        if(x==0){
            return 0;
        }
        if(x<0){
            flag = -1;
            x=-x;
        }
        while(x!=0){
            list.add(x%10);
            x=x/10;
        }
        //StringBuilder，它是一个可变对象，可以预分配缓冲区，
        // 这样往StringBuilder中新增字符时，不会创建新的临时对象(相较于直接使用“+”)
        StringBuilder strNum = new StringBuilder();
        for(int num:list){
            strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        return finalInt*flag;

    }
}
