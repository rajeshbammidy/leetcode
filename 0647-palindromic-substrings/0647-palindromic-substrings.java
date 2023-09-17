class Solution {
    static int count = 0;

    public int countSubstrings(String s) {
        count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            expand(i, i, n, s);
            expand(i, i + 1, n, s);
        }
        return count;
    }

    void expand(int start, int end, int n, String str) {
        while (start >= 0 && end < n && str.charAt(start) == str.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}
