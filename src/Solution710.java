import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-21 09:14
 * @Description:
 */
public class Solution710 {
    //[0,wlen)中的黑数到[wlen,N)的白数一一映射
    Map<Integer, Integer> m;
    Random r;
    //白名单长度
    int wlen;
    //黑名单长度
    int blen;
    public Solution710(int N, int[] blacklist) {
        blen=blacklist.length;
        wlen=N-blen;
        m = new HashMap<>();
        r = new Random();
        //存储后半部分的白数
        Set<Integer> restWhite=new HashSet<>();
        for(int i=wlen;i<N;i++){
            restWhite.add(i);
        }
        for(int b:blacklist){
            restWhite.remove(b);
        }
        Iterator<Integer> wi = restWhite.iterator();
        for(int b:blacklist){
            //如果是前半部分的黑数则建立映射
            if (b<wlen){
                m.put(b,wi.next());
            }
        }


    }

    public int pick() {
       int rKey=r.nextInt(wlen);
       return m.getOrDefault(rKey,rKey);
    }
}
