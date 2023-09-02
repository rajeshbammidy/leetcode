class Solution {
    int dp[];

    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        for (String x : dictionary) {
            char ch = x.charAt(0);
            map.putIfAbsent(ch, new ArrayList<String>());
            map.get(ch).add(x);
        }
        for (char ch : map.keySet()) {
            map.get(ch).sort((a, b) -> b.length() - a.length());
        }

        return recur(0, s, map);
    }

    int recur(int i, String s, HashMap<Character, ArrayList<String>> map) {
        int n = s.length();
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        int value = Integer.MAX_VALUE;
        char ch = s.charAt(i);
        if (map.containsKey(ch)) {
            for (int j = 0; j < map.get(ch).size(); j++) {
                String cString = map.get(ch).get(j);
                System.out.println(cString);
                int clen = cString.length();
                if ((clen <= n - i) && cString.equals(s.substring(i, i + clen))) {
                    value = Math.min(value, recur(i + clen, s, map));
                }
            }
        }
        value = Math.min(value, 1 + recur(i + 1, s, map));
        return dp[i] = value;
    }
}
