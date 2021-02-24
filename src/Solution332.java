import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-28 23:28
 * @Description:
 */
public class Solution332 {
    Map<String, PriorityQueue<String>> map;
    int finalSize=0;
    public List<String> findItinerary(List<List<String>> tickets) {
        map=new HashMap<>();
        for (List<String> list : tickets) {
            PriorityQueue<String> pq = map.getOrDefault(list.get(0), new PriorityQueue<String>());
            pq.add(list.get(1));
            map.put(list.get(0), pq);
        }

        List<String> res = new ArrayList<>();
        dfs("JFK",map,res);
        List<String> re = new ArrayList<>();
        for(int i=res.size()-1;i>=0;i--){
            re.add(res.get(i));
        }
        return re;

    }
    /**
     * @param string
     * @param map
     * @param res
     */
    private static void dfs(String from, Map<String, PriorityQueue<String>> map, List<String> res) {
        while(!map.isEmpty() && map.containsKey(from)){
            if(map.get(from).size()>0){
                String to = map.get(from).poll();
                dfs(to,map,res);
            }else map.remove(from);

        }
        res.add(from);

    }


}
