class Solution {

    public int[][] reconstructQueue(int[][] people) {
        //sort in descending order when the k is not equal, when k is equal then sort those elements in ascending order
        Arrays.sort(
            people,
            (a, b) -> {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        );

        System.out.println(Arrays.deepToString(people));

        LinkedList<int[]> list = new LinkedList<>();
        for (int p[] : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[][] {});
    }
}
