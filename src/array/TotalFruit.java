package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * »¬¶¯´°¿Ú
 */
public class TotalFruit {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
    public static int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(fruits[0], 1);
        while(r<fruits.length){
            if(map.size()<=2){
                max = max>r-l+1?max:r-l+1;
                r++;
                if(r<fruits.length) {
                    map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);
                }
            }else{
                map.put(fruits[l], map.getOrDefault(fruits[l],0)-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }

        }
        return max;
    }
}
