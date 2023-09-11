class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, res, n);
        System.out.println(res);
        return res;
    }

    private void backtrack(String str, int l, int r, List<String> res, int n) {
        System.out.println(str);
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }

        if (l < n) {
            backtrack(str + "(", l + 1, r, res, n);
        }
        if (r < n && l > r) {
            backtrack(str + ")", l, r + 1, res, n);
        }
    }
}
