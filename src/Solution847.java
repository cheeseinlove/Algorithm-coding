import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-16 22:42
 * @Description:
 */
public class Solution847 {
    //经典图的bfs遍历+记录步长
    public int shortestPathLength(int[][] graph) {
        int len=graph.length;
        if(graph==null || graph.length==0){
            return 0;
        }
        boolean[][] visited=new boolean[len][1<<len]; // 标记是否访问过,用于避免重复访问
        int finishState=(1<<len)-1;  // 用于检查是否访问完所有的节点,每个位代表一个节点的状态,形如1111
        Queue<int[]> queue=new LinkedList<>(); // 队列里的数组,第一个记录的是标号,第二个是状态
        for(int i=0; i<len; i++){
            queue.offer(new int[]{i,1<<i});
        }
        int step=0;
        /*bfs框架
        1.初始化全部节点入队列
        2.当队列不为空一直循环，外层的大循环
        3.遍历每个队列节点，定下退出条件，开始业务逻辑
        4.遍历当前节点的邻接节点，并做业务逻辑，做完后入队列
        5.保存步长
         */
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                int[] node=queue.poll();
                if(finishState==node[1]){ // 如果标记的节点访问状态是结束,那么返回步长
                    return step;
                }
                for(int next:graph[node[0]]){
                    int nextState=node[1]|(1<<next); // 2个节点相或,标记着访问了这条边的2个点
                    //避免重复访问状态，当节点围成一个圈的时候可能出现重复访问，如123从12到3和21到3就是重复
                    if(visited[next][nextState]){
                        continue;
                    }
                    visited[next][nextState]=true;
                    queue.offer(new int[]{next,nextState}); // 将该节点和边的信息加入bfs对列
                }
            }
            //保存步长，图就是加一步，树就是到下一层
            step++;
        }
        return step;
    }

}
