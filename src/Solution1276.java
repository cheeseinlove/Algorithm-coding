import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-10 23:47
 * @Description:
 */
public class Solution1276 {
    public static void main(String[] args) {
        numOfBurgers(6217958
                ,2289457);
    }
    //巨无霸4+1,小皇堡2+1
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        if(tomatoSlices%2 !=0 || cheeseSlices>tomatoSlices || (tomatoSlices/2)<cheeseSlices){
            return list;
        }
        //全职做小皇堡所剩的材料
        int flat = tomatoSlices-(cheeseSlices*2);
        if(flat ==0){
            list.add(0);
            list.add(cheeseSlices);
            return list;
        }

        if((flat/2)<=cheeseSlices){
            list.add((flat/2));
            list.add(cheeseSlices-(flat/2));
            return list;
        }
        return list;


    }
}
