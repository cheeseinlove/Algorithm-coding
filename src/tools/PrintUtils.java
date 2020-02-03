package tools;

import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-22 15:15
 * @Description:
 */
public class PrintUtils {
    public static void printList(List list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i)+" ");
        }
    }
}
