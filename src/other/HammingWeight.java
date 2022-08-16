package other;

//  java中有三种移位运算符
//  <<:左移运算符，num << 1,相当于num乘以2
//  >:右移运算符，num >> 1,相当于num除以2
//  >>>:无符号右移，忽略符号位，空位都以0补齐
//  无符号右移的规则:忽略符号位扩展，0补最高位  无符号右移运算符>>>只对32位和64位的值有意义
public class HammingWeight {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            if(((n>>>i)&1)==1){
                count++;
            }
        }
        return count;
    }

    //下边这种是比较取巧的方法
    public int hammingWeight1(int n){
        return Integer.bitCount(n);
    }
}
