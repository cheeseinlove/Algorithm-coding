import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-21 09:40
 * @Description:
 */
public class Solution609 {
    public static void main(String[] args) {
        String []paths=new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)","root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        findDuplicate(paths);
    }
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<List<String>>();
        //key为文件内容，value为list的索引下标，相同key放到同一个list
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for (String str : paths) {
            String[] strs = str.split(" ");
            for (int i = 1; i < strs.length; i++) {
                //拿到文件内容
                String key = strs[i].substring(strs[i].indexOf("(") + 1, strs[i].indexOf(")"));
                if (!map.containsKey(key)) {
                    map.put(key, index++);
                    list.add(new ArrayList<String>());
                }
                list.get(map.get(key)).add(strs[0] + "/" + strs[i].substring(0, strs[i].indexOf("(")));
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).size() < 2)
                list.remove(i);
        }
        return list;
    }
}
