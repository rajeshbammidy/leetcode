class Solution {

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0;
        int n = s.length();
        int res = 0;
        while (j < n) {
            char ch = s.charAt(j);
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
            int max = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            int uq = (j - i + 1) - max;
            while (i < j && uq > k) {
                ch = s.charAt(i);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) map.remove(ch);
                i++;
                max = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                    }
                }
                uq = (j - i + 1) - max;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
