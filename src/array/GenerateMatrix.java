package array;

public class GenerateMatrix {
    public static void main(String[] args) {
        generateMatrix(4);
    }
    public static int[][] generateMatrix(int n) {
        int[][] res= new int[n][n];
        int left = 0;
        int right = n;
        int top = 0;
        int end = n;

        int num = 1;

        while (num<=n*n){
            for (int i = left; i < right; i++) {
                res[top][i] = num++;
            }
            top++;

            for (int i = top; i < end; i++) {
                res[i][right-1] = num++;
            }
            right--;

            for (int i = right-1; i >= left ; i--) {
                res[end-1][i] = num++;
            }
            end--;

            for (int i = end-1; i >= top ; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
