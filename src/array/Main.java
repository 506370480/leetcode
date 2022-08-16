package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        int[] nums ={1,0,-1,0,-2,2};
        int target = 0;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int k=j+1;
                int t=nums.length-1;
                while(k<t){
                    int sum=nums[i]+nums[j]+nums[k]+nums[t];
                    if((k!=j+1&&nums[k]==nums[k-1])||(t!=nums.length-1&&nums[t]==nums[t+1])){
                        continue;
                    }
                    if(sum<target){
                        k++;
                    }else if(sum>target){
                        t--;
                    }else{
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(nums[t]);
                        list.add(li);
                        k++;
                        t--;
                        continue;
                    }
                }
            }
        }
    }

}
