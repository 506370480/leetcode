package other;

public class HammingDistance {
    public static void main(String[] args) {
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }

    //整数异或的例子：10^6的二进制结果为1100，转化为十进制即12。
    public static int hammingDistance(int x, int y) {
        //首先转换为二进制，然后使用异或解决
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
