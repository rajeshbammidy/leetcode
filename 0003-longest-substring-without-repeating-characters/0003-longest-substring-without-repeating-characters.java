class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0;
        int max = 1;
        while (j < n) {
            char ch = s.charAt(j);
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
            while (i < j && map.get(ch) > 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}