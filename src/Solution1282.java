import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-23 23:05
 * @Description:
 */
public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //key 为当前size，v为对应的集合
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            List<Integer> l = map.getOrDefault(groupSizes[i], new ArrayList<>());
            l.add(i);
            map.put(groupSizes[i], l);
            //若当前已满，则
            if (l.size()==groupSizes[i]){
                res.add(l);
                map.remove(groupSizes[i]);
            }
        }
//        for(Integer key:map.keySet()){
//            int size = key;
//            List<Integer> s = map.get(key);
//            int index = 0;
//            for(;index<s.size();){
//                List<Integer> temp = new ArrayList<>();
//                while(temp.size()<size){
//                    temp.add(s.get(index++));
//                }
//                res.add(temp);
//            }
//        }
        return res;
    }
}
