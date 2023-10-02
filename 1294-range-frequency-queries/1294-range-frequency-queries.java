class RangeFreqQuery {
    List<Integer> list[];

    public RangeFreqQuery(int[] arr) {
        list = new ArrayList[(int) (1e4 + 1)];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            list[arr[i]].add(i);
        }
    }

    public int query(int left, int right, int value) {
        int rt = Math.abs(Collections.binarySearch(list[value], right) + 1);
        int lt = Collections.binarySearch(list[value], left);
        if (lt < 0) lt = Math.abs(lt + 1);
        return rt - lt;
    }
}
/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
