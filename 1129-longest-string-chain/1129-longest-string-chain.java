class Solution {

    boolean isValid(int j, int i, String words[]) {
        String delString = words[i];
        String prevString = words[j];
        for (int k = 0; k < delString.length(); k++) {
            if (prevString.equals(delString.substring(0, k) + delString.substring(k + 1))) return true;
        }
        return false;
    }

    // public int longestStrChain(String[] words) {
    //     int n = words.length;
    //     int dp[] = new int[n];
    //     int lsc = 1;
    //     Arrays.sort(words, (a, b) -> a.length() - b.length());
    //     Arrays.fill(dp, 1);
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (words[i].length() - words[j].length() > 1) continue;
    //             if (isValid(j, i, words) && (dp[j] + 1) > dp[i]) {
    //                 dp[i] = dp[j] + 1;
    //                 lsc = Math.max(lsc, dp[i]);
    //             }
    //         }
    //     }
    //     return lsc;
    // }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int lsc = 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap();
        for (String str : words) {
            int maxCount = 1;
            for (int i = 0; i < str.length(); i++) {
                String nStr = str.substring(0, i) + str.substring(i + 1);
                maxCount = Math.max(maxCount, dp.getOrDefault(nStr, 0) + 1);
            }
            lsc = Math.max(maxCount, lsc);
            dp.put(str, maxCount);
        }
        return lsc;
    }
}
