class NumArray {
    int tree[];
    int orgNums[];
    int n = 0;

    int buildST(int ss, int se, int si, int nums[]) {
        if (ss == se) {
            tree[si] = nums[ss];
            return tree[si];
        }
        int mid = (ss + se) / 2;
        tree[si] = buildST(ss, mid, 2 * si + 1, nums) + buildST(mid + 1, se, 2 * si + 2, nums);
        return tree[si];
    }

    public NumArray(int[] nums) {
        n = nums.length;
        orgNums = nums;
        tree = new int[4 * n];
        buildST(0, n - 1, 0, nums);
    }

    public void update(int index, int val) {
        int diff = val - orgNums[index];
        orgNums[index] = val;
        updateVal(0, n - 1, diff, index, 0);
    }

    void updateVal(int ss, int se, int diff, int i, int si) {
        if (i < ss || i > se) return;
        tree[si] += diff;
        if (ss < se) {
            int mid = (ss + se) / 2;
            updateVal(ss, mid, diff, i, 2 * si + 1);
            updateVal(mid + 1, se, diff, i, 2 * si + 2);
        }
    }

    public int sumRange(int left, int right) {
        return getSum(0, n - 1, left, right, 0);
    }

    int getSum(int ss, int se, int qs, int qe, int si) {
        if (qs > se || qe < ss) return 0;
        if (qs <= ss && qe >= se) return tree[si];
        int mid = (ss + se) / 2;
        return getSum(ss, mid, qs, qe, 2 * si + 1) + getSum(mid + 1, se, qs, qe, 2 * si + 2);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
