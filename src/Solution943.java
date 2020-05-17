import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-25 23:43
 * @Description:
 */
public class Solution943 {
    public static void main(String[] args) {
        System.out.println(shortestSuperstring(new String[]{"catg","ctaagt","gcta","ttca","atgcatc"}));
    }

    public static String shortestSuperstring(String[] A) {
        int n = A.length;
        //linki,j代表，索引下标为j的字符串跟在i后面会新增的cost长度，如co+od=1,bg+saw=3
        int link[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                link[i][j]=cost(A[i],A[j]);
                link[j][i]=cost(A[j],A[i]);
            }
        }

        int end = (1 << n) - 1;
        //遍历的节点集合为i，以节点j结尾的最小值
        int dp[][] = new int[end + 1][n];
        //对应dp数组的上一个路劲节点，用于拼接字符串，这里不直接定义字符串数组是为了节约空间
        int parent[][]=new int[end+1][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i=0;i<n;i++){
            dp[1<<i][i]=A[i].length();
        }

        for(int s=1;s<=end;s++){
            for(int i=0;i<n;i++){
                //当前状态s没有到过节点i
                if ((s&(1<<i))==0){
                    continue;
                }
                int pre=s-(1<<i);
                //遍历当前状态s,i的前一个最短节点
                for(int j=0;pre>0&&j<n;j++){
                    if (dp[pre][j]+link[j][i]<dp[s][i]&&(pre&(1<<j))!=0){
                        dp[s][i]=dp[pre][j]+link[j][i];
                        parent[s][i]=j;
                    }
                }
            }
        }

        String ans="";
        int min=Integer.MAX_VALUE;
        int last=0;
        for(int i=0;i<n;i++){
            if (dp[end][i]<min){
                last=i;
                min =dp[end][i];
            }
        }
        while (end>0){
            int temp=end;
            int temp2=last;
            int cost=cost(A[last],ans);
            ans=A[last]+ans.substring(ans.length()-cost);

            last=parent[temp][last];
            end-=(1<<temp2);
        }
        return ans;

    }

    public static int cost(String a, String b) {
        int cost = b.length();
        for (int k = Math.min(a.length(), b.length()); k > 0; k--) {
            if (a.endsWith(b.substring(0, k))) {
                cost -= k;
                return cost;
            }
        }
        return cost;
    }
}
