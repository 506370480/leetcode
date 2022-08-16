package hashset;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        isHappy(2);
    }

    public static boolean isHappy(int n) {
        //ÎŞÏŞÑ­»·
        Set<Integer> hashset = new HashSet<>();
        int sum = n;
        hashset.add(n);
        while(sum!=1){
            n = sum;
            sum=0;
            while(n!=0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            if(hashset.contains(sum)){
                return false;
            }
            hashset.add(sum);
        }
        return true;
    }
}
