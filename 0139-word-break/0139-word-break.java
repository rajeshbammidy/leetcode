class Solution {
    Integer dp[];

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        dp = new Integer[s.length()];
        for (String str : wordDict) set.add(str);
        return recur(0, s, set);
    }

    boolean recur(int index, String str, HashSet<String> set) {
        int n = str.length();
        if (index >= n) {
            return true;
        }
       if(dp[index]!=null)return dp[index]==1?true:false;
        for (int i = index; i < n; i++) {
            String temp = str.substring(index, i + 1);
            if (set.contains(temp)) {
                if (recur(i + 1, str, set)) {
                   //dp[index]=1;
                    return true;
                }
            }
        }
        dp[index]=0;
        return false;
    }
}
