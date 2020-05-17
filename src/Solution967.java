import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-30 23:13
 * @Description:
 */
public class Solution967 {
    public static void main(String[] args) {
        int a[] = numsSameConsecDiff(2, 2);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        int init[]=new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(Arrays.stream(init).boxed().collect(Collectors.toList()));
        for(int n=2;n<=N;n++){
            List<Integer> cur=new ArrayList<>();
            List<Integer> pre=dp.get(n-2);
            for(int i:pre) {
                //个位数
                int k=i%10;
                    if (k + K < 10) {
                        cur.add(i*10+k + K);
                    }
                    //防止重复加入
                    if (k - K>=0&&K!=0){
                        cur.add(i*10+k - K);
                    }
            }
            dp.add(cur);
        }

 return dp.get(N-1).stream().mapToInt(Integer::valueOf).toArray();

    }
}
