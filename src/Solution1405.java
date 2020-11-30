import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-26 23:22
 * @Description:
 */
public class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        b += 1000;
        c += 2000;
        String[] s = new String[]{"a", "b", "c"};
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2 % 1000) - (o1 % 1000);
            }
        });
        if (a % 1000 > 0) {
            pq.add(a);
        }
        if (b % 1000 > 0) {
            pq.add(b);
        }
        if (c % 1000 > 0) {
            pq.add(c);
        }
        while (!pq.isEmpty()) {
            int firstMax = pq.poll();
            int count=canConcact(sb,s,firstMax);
            while (count>0){
                sb.append(s[firstMax / 1000]);
                firstMax--;
                count--;
            }
            //如果没有用来间隔的字符了直接返回
            if (pq.isEmpty()) {
                return sb.toString();
            }
            int secondMax = pq.poll();

            sb.append(s[secondMax / 1000]);
            secondMax--;
            //如果还有剩余字符才入队
            if (firstMax % 1000 > 0) {
                pq.add(firstMax);
            }
            if (secondMax % 1000 > 0) {
                pq.add(secondMax);
            }
        }
        return sb.toString();

    }
    //返回首先拼接的字符这次能拼几个
    public int canConcact(StringBuilder sb,String[]s,int v){
        //如果剩余数目大于等于2，最多先拼2个
        int count=2;
        //还剩几个
        int last=v%1000;
        if (sb.length()>0&&String.valueOf(sb.charAt(sb.length()-1)).equals(s[v/1000])){
            count--;
            if (sb.length()>1&&String.valueOf(sb.charAt(sb.length()-2)).equals(s[v/1000])){
                count--;
            }
        };
        //可能只剩一个取最小值
        if (last==1){
            return Math.min(1,count);
        }
        return count;
    }
}
