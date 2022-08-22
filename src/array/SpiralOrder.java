package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        System.out.println(spiralOrder1(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        //循环 1.条件 2.判断转向边界


        //形状模式，一圈一圈打印，左上角右下角
        int[][] index = new int[matrix.length][matrix[0].length];

        return null;
    }
    //传入矩阵和四个角
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

    public static List<Integer> spiralOrder1(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int end = m;
        int left = 0;
        int right = n;

        while(true){
            for (int i = left; i < right; i++) {
                list.add(matrix[top][i]);
            }
            if(++top==end)  break;

            for (int i = top; i < end; i++) {
                list.add(matrix[i][right-1]);
            }
            if(--right==left)  break;

            for (int i = right-1; i >= left; i--) {
                list.add(matrix[end-1][i]);
            }
            if(--end==top)  break;

            for (int i = end-1; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if(++left==right)  break;
        }
        return list;
    }
}
