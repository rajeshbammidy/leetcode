class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length - 1;
        int c = 1;
        if(arr.length==0 || arr==null)return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            int curSum = arr[i] + c;
            c = curSum / 10;
            list.add(curSum%10);
        }
        //System.out.println(list);
        if (c > 0) list.add(c);
        int ans[] = new int[list.size()];
        n = ans.length - 1;
        for (int i = 0; i < list.size(); i++) {
            ans[n - i] = list.get(i);
        }
        return ans;

    }
}