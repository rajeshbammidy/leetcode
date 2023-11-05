class Solution {

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int x : arr) max = Math.max(max, x);
        if (k >= n) return max;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        LinkedList<Integer> list = new LinkedList<>();
        for (int x : arr) {
            list.add(x);
        }
        int maxK = 0;
        while (true && maxK != k) {
            int a = list.removeFirst();
            int b = list.removeFirst();
            if (a < b) {
                list.addFirst(b);
                list.addLast(a);
                map.put(b, map.getOrDefault(b, 0) + 1);
                maxK = Math.max(maxK, map.get(b));
            } else {
                map.put(a, map.getOrDefault(a, 0) + 1);
                list.addFirst(a);
                list.addLast(b);
                maxK = Math.max(maxK, map.get(a));
            }
           // System.out.println(list);
        }
        for (int x : map.keySet()) {
            if (map.get(x) == k) return x;
        }
        return -1;
    }
}
