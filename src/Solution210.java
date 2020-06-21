import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-17 00:01
 * @Description:
 */
public class Solution210 {
    public static void main(String[] args) {
        int[][] prerequisites =new int[][]{{1,0},{0,1}};
        int ans[]=findOrder(2,prerequisites);
        for(int i=0;i<ans.length;i++)
        System.out.println(ans[i]+" ");
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int ans[]=new int[numCourses];

        int in[]=new int[numCourses];
        Map<Integer,List<Integer>> nextMap= new HashMap<>();
        for(int []a:prerequisites){
            in[a[0]]++;
            List<Integer> next=nextMap.getOrDefault(a[1],new ArrayList<>());
            next.add(a[0]);
            nextMap.put(a[1],next);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if (in[i]==0){
                queue.add(i);
            }
        }
        int count=numCourses;
        while (queue.size()>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int cur=queue.poll();
                ans[numCourses-count]=cur;
                count--;
                List<Integer> next=nextMap.get(cur);
                if (next!=null){
                    for(int j=0;j<next.size();j++){
                        int ne=next.get(j);
                        in[ne]--;
                        if (in[ne]==0){
                            queue.add(ne);
                        }
                    }
                }

            }
        }
        if (count==0){
            return ans;
        }
        return new int[0];
    }
}
