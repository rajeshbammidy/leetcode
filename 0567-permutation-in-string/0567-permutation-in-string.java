class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int s1Freq[] = new int[26];
        int s2Freq[] = new int[26];
        int s1len = 0;
        for (char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }
        for (int x : s1Freq) s1len += x;
        int i = 0;
        int n = s2.length();
        int curlen = 0;
        int start = 0, end = 0;
        while (end < n) {
            char curCh = s2.charAt(end++);
            if (s1Freq[curCh - 'a'] == 0) {
                start = end;
                curlen = 0;
                Arrays.fill(s2Freq, 0);
            } else {
                s2Freq[curCh - 'a']++;
                curlen++;
                while ((start < end) && (s2Freq[curCh - 'a'] > s1Freq[curCh - 'a'])) {
                    s2Freq[s2.charAt(start) - 'a']--;
                    start++;
                    curlen--;
                }
                if (curlen == s1len) {
                    return true;
                }
            }
        }
        return false;
    }
}
