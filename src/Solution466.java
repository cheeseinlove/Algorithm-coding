/**
 * @Author liuxun05
 * @create 2020/2/19 12:36
 **/
public class Solution466 {
    public static void main(String[] args) {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 3;
        System.out.println(getMaxRepetitions(s1, n1, s2, n2));
    }

    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
       //repeat_count是(s1,n1)中s2重复次数,index是s2的索引
        int index = 0, repeat_count = 0;

        int s1_size = s1.length(), s2_size = s2.length();

        for (int i = 0; i < n1; i++) {

            for (int j = 0; j < s1_size; j++) {

                if (s1.charAt(j) == s2.charAt(index))

                    ++index;

                if (index == s2_size) {

                    index = 0;

                    ++repeat_count;

                }

            }

        }
//总的重复次数/s2的重复次数
        return repeat_count / n2;


    }

}
