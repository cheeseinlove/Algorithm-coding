package week_competition;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author liuxun05
 * @create 2020/11/1 10:31
 **/
public class Solution5554 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], Arrays.stream(piece).filter(i -> i != 0).boxed().collect(Collectors.toList()));
        }
        int i = 0;
        while (i<arr.length){
            if (!map.containsKey(arr[i])){
                return false;
            }
            List<Integer> curP=map.get(arr[i]);
            for(int j=0;j<curP.size();j++){
                if(curP.get(j)!=arr[i]){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
