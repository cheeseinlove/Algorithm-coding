import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s == null)
            System.out.print(0);
        int max = 0;
        int start = 0;
        int end = 0;
        int length=1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                length++;
            else {
                if (max<length){
                    start=i-length+1;
                    end=i;
                    max=length;
                    length=1;
                }
            }
        }

System.out.print(max);
    }
}
