package sortandsearch;

public class BubbleSort {
    public static void main(String[] args) {
        sort(new int[]{3,2,1});
    }
    public static int[] sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length- 1 - i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
