class Solution {
    HashMap<String, Boolean> map;

    public boolean isInterleave(String s1, String s2, String s3) {
        map = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if ((n1 + n2) != n3) return false;
        return recur(0, 0, 0, n1, n2, s1, s2, s3);
    }

    boolean recur(int s1i, int s2i, int s3i, int n1, int n2, String s1, String s2, String s3) {
        if (s1i >= n1 && s2i >= n2) {
            return true;
        }
        String key = s1i + "#" + s2i;
        if (map.containsKey(key)) return map.get(key);
        boolean left = false;
        boolean right = false;
        if (s1i < n1 && s1.charAt(s1i) == s3.charAt(s3i)) {
            left = recur(s1i + 1, s2i, s3i + 1, n1, n2, s1, s2, s3);
        }
        if (s2i < n2 && s2.charAt(s2i) == s3.charAt(s3i)) {
            right = recur(s1i, s2i + 1, s3i + 1, n1, n2, s1, s2, s3);
        }
        map.put(key, left || right);
        return left || right;
    }
}
