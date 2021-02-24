import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-05 23:45
 * @Description:
 */
public class Solution89 {
    List<Integer> res = new ArrayList();
    boolean[] visited;
    public List<Integer> grayCode(int n) {
        visited = new boolean[1<<n];
        dfs(0,n);
        return res;
    }

    boolean dfs(int cur,int n){
        if(res.size()==(1<<n))
            return true;
        res.add(cur);
        visited[cur]=true;
        for(int i=0;i<n;i++){
            int next = cur^(1<<i); //这里改变cur的某一位，用异或
            if(!visited[next]&&dfs(next,n))
                return true;
        }
        visited[cur] = false;
        return false;

    }
}
