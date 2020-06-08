import java.util.HashSet;
import java.util.Set;

/**
 * @Author liuxun05
 * @create 2020/3/20 23:17
 **/
public class Solution898 {
    public int subarrayBitwiseORs(int[] A) {
        Set <Integer>mset=new HashSet<>();
        int prebit = 0;
        for (int i = 0; i < A.length; i++) {
            int currbit = 0;
            for(int j = i; j >= 0; j--) {
                currbit |= A[j];
                mset.add(currbit);
                //不算了是因为若A&B=B则A|B=A，所以再往前相与结果都是A即currbit
                if ((currbit & prebit) == prebit) {
                    break;  // 所有bit都置位则终止循环
                }
            }
            prebit |= A[i]; // 记录可以置位的bit
        }
        return mset.size();
    }
}
