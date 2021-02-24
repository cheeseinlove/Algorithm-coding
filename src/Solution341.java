import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-29 22:41
 * @Description:
 */
public class Solution341 {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        int index=0;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
           buildList(nestedList,list);

        }
        public void buildList(List<NestedInteger> nestedList,List<Integer> list){
            for(NestedInteger nestedInteger:nestedList){
                //如果当前位置是嵌套
                if (!nestedInteger.isInteger()){
                    buildList(nestedInteger.getList(),list);
                }else {
                    list.add(nestedInteger.getInteger());
                }
            }
        }

        @Override
        public Integer next() {
         return list.get(index++);
        }

        @Override
        public boolean hasNext() {
         return index<list.size();
        }
    }
}
