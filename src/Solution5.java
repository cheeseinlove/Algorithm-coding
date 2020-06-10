class Solution5 {
    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; j >= i; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else if (i == j || i == j - 1)
                break;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        String result = null;
        int length = 1;
        int longest = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; longest <= j - i + 1; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String pa = s.substring(i, j + 1);
                    length = j - i + 1;
                    if (isPalindrome(pa)) {
                        if (length >= longest) {
                            longest = length;
                            result = pa;

                        }
                    }

                }

            }

        }
        return result;
    }


    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 1) {
            return "";
        }
        int max = 1;
        String ans = s.substring(0, 1);

        boolean dp[][] = new boolean[len][len];
        for (int k = 1; k <= len; k++) {
            for (int start = 0; start <= len - k; start++) {
                int end = start + k - 1;
                if (start == end) {
                    dp[start][end] = true;
                } else if (s.charAt(start) == s.charAt(end) && ((end - start == 1) || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    if (max < k) {
                        ans = s.substring(start, end + 1);
                        max = Math.max(max, k);
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String... args) {
        String test = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String test2="ccc";
        System.out.println(longestPalindrome2(test2));
    }
}
