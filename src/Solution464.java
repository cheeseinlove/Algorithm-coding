import java.util.HashMap;
import java.util.Map;

/**
 * @Author liuxun05
 * @create 2020/2/18 22:47
 **/
public class Solution464 {
    public static void main(String[] args) {
    }
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //总和
        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        Map<Integer,Boolean> map=new HashMap<>();
        return canWin(maxChoosableInteger,desiredTotal,0,map);
    }

    public static boolean canWin(int chooseable,int nowTarget,int used,Map<Integer,Boolean> map)
    {
        //走缓存，当used相同时结果是一样的
        if(map.containsKey(used))
            return map.get(used);
        for(int i=1;i<=chooseable;i++)
        {
            //判断当前数是否被选择过
            if((used & (1<<i))==0)
            {
                //若当前选择的数大于剩下目标值或继续选下去选手2不能赢，则当前能赢
                if(nowTarget<=i || !canWin(chooseable,nowTarget-i,used | (1<<i),map))
                {
                    map.put(used,true);
                    //若当前选手轮次能找到一个i满足if判断则直接返回稳赢
                    return true;
                }
            }
        }
        map.put(used,false);
        return false;
    }
}
