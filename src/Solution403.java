import java.util.*;

/**
 * @Author liuxun05
 * @create 2020/2/16 21:05
 **/
public class Solution403 {
    public static void main(String[] args) {
        int stones1[] = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        int stones2[] = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones1));
        System.out.println(canCross(stones2));
    }

    public static boolean canCross(int[] stones) {
        if(stones.length<2){
            return true;
        }
        if (stones[1]!=1){
            return false;
        }
        Map<Integer,Set<Integer>> map=new HashMap<>();
        map.put(0,new HashSet<>(Arrays.asList(0)));
        map.put(1,new HashSet<>(Arrays.asList(1)));
        for(int i = 2;i<stones.length;i++){
            int cur=stones[i];
            Set<Integer> set=new HashSet<>();
            for(int j=i-1;j>=1;j--){
              int pre=stones[j];
              if (map.get(j).contains(cur-pre+1)){
                  set.add(cur-pre);
              }
              if (map.get(j).contains(cur-pre)){
                  set.add(cur-pre);
              }
              if (map.get(j).contains(cur-pre-1)){
                  set.add(cur-pre);
              }
            }
            map.put(i,set);
        }
        return map.get(stones.length-1).size() > 0;
    }
}
