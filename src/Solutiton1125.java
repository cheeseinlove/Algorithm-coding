import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-24 20:55
 * @Description:
 */
public class Solutiton1125 {
    public static void main(String[] args) {
//        String requestSkills[] = new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"};
//        List<List<String>> people = new ArrayList<>();
//        List<String> p0 = new ArrayList<>(Arrays.asList("algorithms", "math", "java"));
//        List<String> p1 = new ArrayList<>(Arrays.asList("algorithms", "math", "reactjs"));
//        List<String> p2 = new ArrayList<>(Arrays.asList("java", "csharp", "aws"));
//        List<String> p3 = new ArrayList<>(Arrays.asList("reactjs", "csharp"));
//        List<String> p4 = new ArrayList<>(Arrays.asList("csharp", "math"));
//        List<String> p5 = new ArrayList<>(Arrays.asList("aws", "java"));
//        people.add(p0);
//        people.add(p1);
//        people.add(p2);
//        people.add(p3);
//        people.add(p4);
//        people.add(p5);
//        String requestSkills2[] = new String[]{"java","nodejs","reactjs"};
//        List<List<String>> people2 = new ArrayList<>();
//        List<String> p02 = new ArrayList<>(Arrays.asList("java"));
//        List<String> p12 = new ArrayList<>();
//        List<String> p22 = new ArrayList<>();
//        List<String> p32 = new ArrayList<>(Arrays.asList("nodejs","reactjs"));
//        people2.add(p02);
//        people2.add(p12);
//        people2.add(p22);
//        people2.add(p32);

        List<List<String>> people3 = new ArrayList<>();
        String requestSkills3[] = new String[]{"mwobudvo", "goczubcwnfze", "yspbsez", "pf", "ey", "hkq"};
        String s3[][] = new String[][]{{}, {"mwobudvo"}, {"hkq"}, {"pf"}, {"pf"}, {"mwobudvo", "pf"}, {}, {"yspbsez"}, {}, {"hkq"}, {}, {}, {"goczubcwnfze", "pf", "hkq"}, {"goczubcwnfze"}, {"hkq"}, {"mwobudvo"}, {}, {"mwobudvo", "pf"}, {"pf", "ey"}, {"mwobudvo"}, {"hkq"}, {}, {"pf"}, {"mwobudvo", "yspbsez"}, {"mwobudvo", "goczubcwnfze"}, {"goczubcwnfze", "pf"}, {"goczubcwnfze"}, {"goczubcwnfze"}, {"mwobudvo"}, {"mwobudvo", "goczubcwnfze"}, {}, {"goczubcwnfze"}, {}, {"goczubcwnfze"}, {"mwobudvo"}, {}, {"hkq"}, {"yspbsez"}, {"mwobudvo"}, {"goczubcwnfze", "ey"}};
        for (int i = 0; i < s3.length; i++) {
            List<String> list = Arrays.asList(s3[i]);
            people3.add(list);
        }
        int a[] = smallestSufficientTeam(requestSkills3, people3);
        for (int num : a) {
            System.out.println(num);
        }
        for (String s : s3[12]) {
            System.out.print(s + ",");
        }
        System.out.println();
        for (String s : s3[23]) {
            System.out.print(s + ",");
        }
        System.out.println();
        for (String s : s3[39]) {
            System.out.print(s + ",");
        }
    }

    /**
     * 先预处理字符串为整形数，这样可以位运算比较
     *
     * @param req_skills
     * @param people
     * @return
     */
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();
        Map<String, Integer> map = new HashMap<>();
        //预处理字符串
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }
        int peoples[] = new int[m];
        for (int i = 0; i < m; i++) {
            List<String> p = people.get(i);
            int status = 0;
            for (String s : p) {
                //位运算表示每一个人拥有的技能情况
                status = status | (1 << map.get(s));
            }
            peoples[i] = status;
        }
        //dp数组表示在当前状态值i时，选择的最少人数
        int[] dp = new int[1 << n];
        //初始化为-1
        Arrays.fill(dp, -1);
        //初始状态，从这个状态开始选择people
        dp[0] = 0;

        int final_state = (1 << n) - 1;


        int[] preState = new int[1 << n];
        int[] pre = new int[1 << n];

        //01背包的模板，外层是每个物品这题是每个人选或者不选，内层是背包容量大小，这题是综合技能情况
        for (int i = 0; i < m; i++) {
            for (int j = final_state; j >= 0; j--) {
                if (dp[j] == -1) {
                    continue;
                }
                //state代表当前已拥有的能力为j时选择第i个人的综合能力值,从j选择people[i]到达state，dp[state]=math.min(dp[state],dp[j]+1)
                int state = j | peoples[i];
                if (dp[state] == -1 || dp[state] > dp[j] + 1) {
                    dp[state] = dp[j] + 1;
                    preState[state] = j;
                    pre[state] = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        //最终选择的小组状态为(1 << n) - 1
        int state = final_state;
        while (state != 0) {
            res.add(pre[state]);
            state = preState[state];
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;


    }
}
