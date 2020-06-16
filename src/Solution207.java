import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-15 23:39
 * @Description:
 */
public class Solution207 {
    public static void main(String[] args) {
        int[][] prerequisites =new int[][]{{1,0},{2,0}};
        System.out.println(canFinish(3,prerequisites));
    }

    //有向图判断带环
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length<2){
            return true;
        }
        //记录每个节点入度个数
        int[] indegrees = new int[numCourses];
        //记录每个节点的下个节点
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int a[] : prerequisites) {
            indegrees[a[0]]++;
            List<Integer> next = adjacency.getOrDefault(a[1], new ArrayList<>());
            next.add(a[0]);
            adjacency.put(a[1], next);
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = numCourses;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pre = queue.poll();
                count--;
                List<Integer> nextList = adjacency.get(pre);
                if (nextList != null){
                    for (int j = 0; count != 0 && j < nextList.size(); j++) {
                        int next = nextList.get(j);
                        //入度减1
                        indegrees[next]--;
                        if (indegrees[next] == 0) {
                            queue.add(next);
                        }
                    }
            }
            }


        }
        return count == 0;
    }
}
