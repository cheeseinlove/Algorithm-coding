import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String... args) {
        List<String> strings = new ArrayList<>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        for (String s : strings) {
            if (s.equals("bb"))
                strings.remove("bb");
            if (s.equals("cc"))
                System.out.println(s);
        }
    }
}
