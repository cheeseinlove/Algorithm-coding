import org.junit.Test;

import static org.junit.Assert.*;

public class Solution20Test {

    @Test
    public void test() {
        String s = "(([[{{[}}]]))";
        String test2="}}";
//        System.out.print(isPair(test2,0));
        System.out.print(isValid(s));
//        s.replace("{}","");
//        System.out.print(s.replace("{}",""));
    }

    public boolean isValid(String s) {
        int i = 0;
        while (!s.equals("")) {
            if(i==s.length()-1)
                return false;
            if (isPair(s, i)) {
                s=s.replace(s.substring(i, i + 2), "");
                i = 0;
                continue;
            }

            i++;

        }
return  true;
    }

    public boolean isPair(String s, int index) {
        switch (s.charAt(index)){
            case '(':if (s.charAt(index+1)==')')return true;else return false;
            case '[':if (s.charAt(index+1)==']')return true;else return false;
            case '{':if (s.charAt(index+1)=='}')return true;else return false;

        }

        return false;
    }

}