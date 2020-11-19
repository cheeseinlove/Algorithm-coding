import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-10 23:26
 * @Description:
 *
 *
 */
public class Solution406 {
    /**先对数组排序，h降序，k升序。
     *h降序因为先排身高更高的
     *在每一步排序时，我们都是用k作为"当前状态"下的索引，由于之前排的都是更高身高的，所以影响当前身高排序的更高的人都已经排过了
     * 所以在当前状态下是有序的，最终排完所有人是全局有序的。这里使用了贪心的思想，即能影响我位次的都已经排了，所以当前的k一定是当前的索引，     *局部最优-》全局最优。
     * 同理，由于身高相同也算在k里面，所以k更大的应该后排，所以k是降序
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int [] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int [] peo:people){
            res.add(peo[1], peo);
        }
        return res.toArray(new int [res.size()][2]);


    }
}
