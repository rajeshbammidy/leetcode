class Solution {
    int dp[];

    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        /**
         * Character to string starts with char map
         */
        for (String x : dictionary) {
            char ch = x.charAt(0);
            map.putIfAbsent(ch, new ArrayList<String>());
            map.get(ch).add(x);
        }
        /**
         *Sort them according to the length of the strings(being greedy).
         */
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
        //check if the char exists in the map
        if (map.containsKey(ch)) {
            //if exists iterate over the strings in the map
            for (int j = 0; j < map.get(ch).size(); j++) {
                String cString = map.get(ch).get(j);
                int clen = cString.length();
                //check if the string in the map exists in our string s
                if ((clen <= n - i) && cString.equals(s.substring(i, i + clen))) {
                    //if exists skip to the next elegible character
                    value = Math.min(value, recur(i + clen, s, map));
                }
            }
        }
        //if the character exists in the map we have considered it above, lets try skipping it now.
        value = Math.min(value, 1 + recur(i + 1, s, map));
        return dp[i] = value;
    }
}
