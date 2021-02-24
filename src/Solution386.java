import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-02-04 23:48
 * @Description:
 */
public class Solution386 {
    private static List<Integer> ans;

    public static void main(String[] args) {
        lexicalOrder(13);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    //十叉树的先序遍历
    public static List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        dfs(0, n);

        return ans;
    }

    public static void dfs(int cur, int max) {
         if (cur>max){
             return;
         }
         //先序遍历，根-》左-》右
        if (cur!=0){
            ans.add(cur);
        }
         for(int i=0;i<=9;i++){
             if (cur==0&&i==0){
                 continue;
             }
             dfs(cur*10+i,max);
         }
    }
}
