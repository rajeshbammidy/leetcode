class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(groupSizes[i], new ArrayList<Integer>());
            map.get(groupSizes[i]).add(i);
        }
        for (int key : map.keySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : map.get(key)) {
                temp.add(x);
                if (temp.size() == key) {
                    result.add(temp);
                    temp = new ArrayList<>();
                }
            }
        }
        return result;
    }
}
