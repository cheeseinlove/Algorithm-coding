import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-19 23:31
 * @Description:
 */
public class Solution1005 {
    public static void main(String[] args) {
        int A[]=new int[]{-8,3,-5,-3,-5,-2};
        System.out.println(largestSumAfterKNegations(A,6));
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        int sum=0;
        int negative=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<A.length;i++){
            if (A[i]<0) {
                negative++;
            }
            pq.add(-A[i]);
            sum+=A[i];
        }
        if (K>negative){
            if ((K-negative)%2==0){
                K=negative;
            }else {
                K=negative+1;
            }
        }
        for(int i=0;i<K;i++){
            //若当前最大值都为0了，那以后的数都是小于等于0的数只能让数组总和更小
            if (pq.peek()==0){
                break;
            }
            int temp=pq.poll();
            sum+=temp*2;
            pq.add(-temp);
        }
        return sum;
    }
}
