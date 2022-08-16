package greedyalgorithm;

public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 5, 10, 5, 20, 10, 5, 5}));
    }

    //������Ҫint��¼����Ǯ�ҵ�����
    //��������ֵΪ20��������õ���̰�ģ���������10+5����������5+5+5��
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                }
                else return false;
            }

        }
        return true;
    }
}
