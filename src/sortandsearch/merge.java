package sortandsearch;

import java.util.Arrays;

//ֻҪ�ܽ�����⼴�ɣ����ܺ�è��è�������Ƿ�����
public class merge {
    public static void main(String[] args) {
        merge1(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n) {
            if(nums1[i]<=nums2[j]){
                nums[k] = nums1[i];
                i++;
                k++;
            }else{
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        if(i==m){
            while(j<n) {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        if(j==n){
            while(i<m){
                nums[k] = nums1[i];
                i++;
                k++;
            }
        }
        //���������ַ�ʽ����һ����forѭ�����ڶ�����nums.clone����������Arrays.copyOf()
        //����copyof���ַ�ʽʵ�����������µ����飬���ǲ��еġ�
        nums1 = nums.clone();
        System.out.println(nums1);
    }

    //����˼·�ǴӺ���ǰ�����Ḳ��
    public static void merge1(int[] nums1, int m, int[] nums2, int n){
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]<=nums2[j]){
                nums1[k] = nums2[j];
                j--;
                k--;
            }else{
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        if(i<0){
            while(j>=0){
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }
    }

    //ֱ����������뷨�Լ�һֱû�뵽
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
