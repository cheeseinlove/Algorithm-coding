import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-05-21 08:47
 * @Description:
 */
public class Solution1202 {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();

        List<Integer> p1 = new ArrayList<>();
        p1.add(0);
        p1.add(3);
        List<Integer> p2 = new ArrayList<>();
        p2.add(1);
        p2.add(2);
        List<Integer> p3 = new ArrayList<>();
        p3.add(0);
        p3.add(2);

        pairs.add(p1);
        pairs.add(p2);
        pairs.add(p3);
        System.out.println(smallestStringWithSwaps(s, pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();

        DSU dsu = new DSU(100000);
        //初始化构造下标集合
        for (List<Integer> list : pairs)
            dsu.union(list.get(0), list.get(1));
        //每个下标集合有1个leader，用leader作为key(唯一)，下标集合List作为value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //从小到大遍历，使得List<Integer>中的值是有序的(事后不用再排序了)
        for (int i = 0; i < len; ++i) {
            int key = dsu.find(i);
            map.computeIfAbsent(key, unused -> new ArrayList<>()).add(i);
        }

        StringBuilder res = new StringBuilder(s);
        //遍历所有每个下标集合，进行字符局部排序
        for (List<Integer> idx_list : map.values())
            if (idx_list.size() > 1)
                sort(res, idx_list);

        return res.toString();
    }

    //根据下标集合进行局部排序
    private static void sort(StringBuilder res, List<Integer> idx_list) {
        int len = idx_list.size();
        char[] array = new char[len];
        //根据下标集合构建字符集合
        for (int i = 0; i < len; ++i)
            array[i] = res.charAt(idx_list.get(i));
        //将字符集合排序
        Arrays.sort(array);
        //将字符按序“插入”回StringBuilder
        for (int i = 0; i < len; ++i)
            res.setCharAt(idx_list.get(i), array[i]);
    }
}

 class DSU {
    int[] parent;

    public DSU(int len) {
        parent = new int[len];
        for (int i = 0; i < len; ++i)
            parent[i] = i;
    }


    public int find(int x) {
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    /*
    x的根节点的父节点指向y节点
     */
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }


}
