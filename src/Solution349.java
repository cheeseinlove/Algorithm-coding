import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-13 22:15
 * @Description:
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();//如果数据量大，应当考虑TreeSet
        for (Integer n : nums1) set1.add(n);
        List<Integer> list = new ArrayList<Integer>();
        for (Integer n : nums2) {
            if(set1.contains(n)){
                list.add(n);
                set1.remove(n);
            }
        }
        int[] output =new int[list.size()];
        for(int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }
}
