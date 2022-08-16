package array;

import java.util.Arrays;

//首先第一点，如果使用int[][] result=matrix,这样他们是同一个对象，变化是会同步的
public class rotateMatrix {
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] result = new int[length][length];
        int i, j;
        for (i = 0; i < length; i++) {
            for (j = 0; j < length; j++) {
                result[i][j] = matrix[length - 1 - j][i];
            }
        }
        matrix = result;//不知道为什么我这里输出的结果是对的，但是力扣上是错的
        System.out.println(Arrays.deepToString(matrix));
    }

    //下边不使用新的空间，使用新的空间其实很简单，只需要对应上去就行了，不使用新的空间呢？
    public static void rotate1(int[][] matrix) {
            int length = matrix.length;
            //因为是对称的，只需要计算循环前半行即可
            for (int i = 0; i < length / 2; i++)
                for (int j = i; j < length - i - 1; j++) {
                    int temp = matrix[i][j];
                    int m = length - j - 1;
                    int n = length - i - 1;
                    matrix[i][j] = matrix[m][i];
                    matrix[m][i] = matrix[n][m];
                    matrix[n][m] = matrix[j][n];
                    matrix[j][n] = temp;
                }
        }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }
}
