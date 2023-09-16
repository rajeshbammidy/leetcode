class Solution {
    /***
        1.Sorting is required to keep all the shorter length string front
        2. We dont have to traverse j to i, instead we can iterate the string and check.
     */
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
