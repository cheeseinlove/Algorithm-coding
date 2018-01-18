import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
    int m=triangle.size();
    int dp[][]=new int[m][m];
    if (triangle.size()==0)
        return 0;
    dp[0][0]=triangle.get(0).get(0);

        for (int i=1;i<m;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0)
                    dp[i][j]=triangle.get(i).get(j)+dp[i-1][0];
                else if(j==triangle.get(i).size()-1)
                    dp[i][j]=triangle.get(i).get(j)+dp[i-1][triangle.get(i-1).size()-1];
                else{
                    dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
Arrays.sort(dp[m-1]);
return dp[m-1][0];

    }
    public static void main(String...args){
        List<List<Integer>> test=new ArrayList<>();
        List<Integer>l1= Arrays.asList(2);
        List<Integer>l2= Arrays.asList(3,4);
        List<Integer>l3= Arrays.asList(6,5,7);
        List<Integer>l4= Arrays.asList(4,1,8,3);
        test.add(l1);
        test.add(l2);
        test.add(l3);
        test.add(l4);
        System.out.print(minimumTotal(test));
    }
}
