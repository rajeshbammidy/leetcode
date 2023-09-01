class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> indegMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
            indegMap.putIfAbsent(i, 0);
        }

        for (int x[] : prerequisites) {
            list.get(x[1]).add(x[0]);
            indegMap.put(x[0], indegMap.get(x[0]) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegMap.entrySet()) {
            if (entry.getValue() == 0) que.add(entry.getKey());
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            res.add(u);
            for (int x : list.get(u)) {
                int iv = indegMap.get(x);
                if (iv - 1 == 0) {
                    que.add(x);
                }
                indegMap.put(x, iv - 1);
            }
        }
        return numCourses == res.size();
    }
}
