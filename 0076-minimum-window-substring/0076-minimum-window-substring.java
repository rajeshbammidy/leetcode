class Solution {
  public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        String str = "";
        int c = 0;
        int ans = Integer.MAX_VALUE;
        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) c++;
            }

            while (c == t.length()) {
                ch=s.charAt(left);
                if (ans > right - left + 1) {
                    str = s.substring(left, right + 1);
                    ans = right - left + 1;

                }
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) c--;
                }

                left++;
            }

        }
        return str;

    }
}