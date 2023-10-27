class Solution {

    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0) return "";

        int start = 0;
        int end = 0;

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int len1 = lps(str, i, i);
            int len2 = lps(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                maxLen = len;
            }
        }

        return str.substring(start, end + 1);
    }

    private int lps(String str, int left, int right) {
        if (left > right || str.length() == 0) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
