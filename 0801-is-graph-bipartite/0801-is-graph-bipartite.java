class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            for (int j = 0; j < graph[i].length; j++) {
                int v = graph[i][j];
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }
        //System.out.println(list);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                queue.add(new Pair<Integer, Integer>(i, 0));
                map.put(i, 0);
                if (!isValidColoring(queue, map, list)) return false;
            }
        }
        return true;
    }

    boolean isValidColoring(Queue<Pair<Integer, Integer>> queue, HashMap<Integer, Integer> map, ArrayList<ArrayList<Integer>> list) {
        while (!queue.isEmpty()) {
           // System.out.println(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                int u = pair.getKey();
                int color = pair.getValue();
                for (int v : list.get(u)) {
                    if (map.containsKey(v) && map.get(v) == color) return false;
                    if (!map.containsKey(v)) {
                        map.put(v, color ^ 1);
                        queue.add(new Pair(v, color ^ 1));
                    }
                }
            }
        }
        return true;
    }
}
