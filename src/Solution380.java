import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-30 22:05
 * @Description:
 */
public class Solution380 {
    class RandomizedSet {
        List<Integer> list;
        Map<Integer,Integer> map;
        Random random ;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list=new LinkedList<>();
            map=new HashMap<>();
            random=new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (!map.containsKey(val)){
                map.put(val,list.size());
                list.add(val);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            //交换最后一个数到删除的位置来让中间删除的数不影响后续的索引
            if (map.containsKey(val)){
                int idx=map.get(val);
                int lastVal=list.get(list.size()-1);
                list.set(idx,lastVal);
                map.put(lastVal,idx);
                list.remove(list.size()-1);
                map.remove(val);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
