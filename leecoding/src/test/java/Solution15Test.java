import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution15Test
{
    @Test
    public void test(){
        int []num=new int[]{0,2,1,-3};
        int target =1;
        System.out.print(threeSumClosest(num,target));
    }



    private int threeSumClosest(int[] nums, int target) {

        for(int i=0;;i++){
            if(find(nums,target+i)){
                return target+i;
            }
            if (find(nums,target-i))
                return target-i;
        }
    }
    private boolean find (int []num,int s){
        List<Integer>list=new LinkedList<>(Arrays.stream(num).boxed().collect(Collectors.toList()));
        for(; list.size()>=3;){
            int sum=list.get(0);
            list.remove(0);
            for(int j=0;j<list.size()-1;j++){
                int now=list.get(j);
                sum+=now;
                list.remove(j);

                if (list.contains(s-sum))
                    return true;
                sum-=now;
                list.add(j,now);
            }
        }
return false;
    }
}