package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        //ѭ�� 1.���� 2.�ж�ת��߽�


        //��״ģʽ��һȦһȦ��ӡ�����Ͻ����½�
        int[][] index = new int[matrix.length][matrix[0].length];

        return null;
    }
    //���������ĸ���
    static void cicle(int[][] mat,int x1,int y1,int x2,int y2,List<Integer> list){
        if(x1>x2||y1>y2){
            return;
        }
        if(x1==x2){
            for (int i = 0; i < mat[0].length; i++) list.add(mat[x1][i]);
            return;
        }
        if(y1==y2){
            for (int i = 0; i < mat.length; i++) list.add(mat[y1][i]);
        }
    }
}
